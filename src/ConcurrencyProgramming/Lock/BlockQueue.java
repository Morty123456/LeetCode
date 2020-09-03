package ConcurrencyProgramming.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wzh
 * @time: 2020/9/2 8:44
 * @description:
 */
public class BlockQueue {
    //队列容器
    private List<Integer> container = new ArrayList<>();
    private volatile int size;
    private volatile int capacity;
    private Lock lock = new ReentrantLock();
    //Condition
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    BlockQueue(int cap){
        this.capacity = cap;
    }
    /**
     * 添加方法
     * @param data
     */
    public void add(int data){
        try {
            lock.lock();
            try {
                while (size>=capacity){
                    System.out.println("阻塞队列已满");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }

            ++size;
            container.add(data);
            isNull.signal();
        }finally {
            lock.unlock();
        }
    }
    /**
     * 取出元素
     */
    public int take(){
        try {
            lock.lock();
            while (size==0){
                System.out.println("阻塞队列已空");
                try {
                    isNull.await();
                } catch (InterruptedException e) {
                    isNull.signal();
                    e.printStackTrace();
                }
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        }finally {
            lock.unlock();
        }
    }
}

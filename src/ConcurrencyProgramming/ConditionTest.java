package ConcurrencyProgramming;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wzh
 * @time: 2020/8/11 17:15
 * @description:
 */
public class ConditionTest {
    public static void main(String[] args) {
        BoundQueue<Integer> boundQueue = new BoundQueue<>(10);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    int a = (int)(Math.random()*10);
                    System.out.println(a);
                    if (a%2==1)
                        boundQueue.add(1);
                    else
                        boundQueue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
class BoundQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
//    private Object object;

    public BoundQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                System.out.println("队列已满");
//                notFull.await();
                wait();
            }
            items[addIndex] = t;
            System.out.println(addIndex+" 位置开始入队");
            if (++addIndex == items.length){
                addIndex = 0;
//                System.out.println("开始新的一轮");
            }
            ++count;
            System.out.println("队列共有 "+count+" 个值");
//            notEmpty.signal();
            notify();
        }finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException{
        lock.lock();
        try {
            while (count==0){
                System.out.println("队列是空的");
//                notEmpty.await();
                wait();
            }
            Object x = items[removeIndex];
            System.out.println(removeIndex+" 位置开始出队");
            if (++removeIndex == items.length)
                removeIndex = 0;
            --count;
            System.out.println("队列共有 "+count+" 个值");
//            notFull.signal();
            notify();
            return (T)x;
        }finally {
            lock.unlock();
        }
    }
}

class BoundQueueSyn<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
//    private Object object;

    public BoundQueueSyn(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        synchronized (this){
            try {
                while (count == items.length){
                    System.out.println("队列已满");
//                notFull.await();
                    wait();
                }
                items[addIndex] = t;
                System.out.println(addIndex+" 位置开始入队");
                if (++addIndex == items.length){
                    addIndex = 0;
//                System.out.println("开始新的一轮");
                }
                ++count;
                System.out.println("队列共有 "+count+" 个值");
//            notEmpty.signal();
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException{
        synchronized (this){
            try {
                while (count == 0) {
                    System.out.println("队列是空的");
//                notEmpty.await();
                    wait();
                }
                Object x = items[removeIndex];
                System.out.println(removeIndex + " 位置开始出队");
                if (++removeIndex == items.length)
                    removeIndex = 0;
                --count;
                System.out.println("队列共有 " + count + " 个值");
//            notFull.signal();
                notify();
                return (T) x;
            } finally {
            }
        }
    }
}


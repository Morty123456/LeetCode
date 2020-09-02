package ConcurrencyProgramming.Lock;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/2 8:58
 * @description:
 */
public class BlockQueueSynchronized {
    private List<Integer> list = new LinkedList<>();
    private volatile int size;
    private volatile int capacity;
    private Object isFull = new Object();
    private Object isNUll = new Object();

    public BlockQueueSynchronized(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(int data){
        while (size==capacity){
            try {
                System.out.println("阻塞队列已满");
                synchronized (isFull){
                    isFull.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(data);
        size++;
        synchronized (isNUll){
            isNUll.notify();
        }
    }
    public int get(){
        while (size==0){
            System.out.println("阻塞队列已空");
            try {
                synchronized (isNUll) {
                    isNUll.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (isFull) {
            isFull.notify();
        }
        --size;
        return list.remove(0);
    }
}

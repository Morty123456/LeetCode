package aa;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test3 {
    public static void main(String[] args) {
        SynQueue synQueue = new SynQueue(3);
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synQueue.add(i);
                System.out.println("生产 "+i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                int res = synQueue.get();
                System.out.println("消费 "+res);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    static class SynQueue{
        int maxSize;
        Lock lock = new ReentrantLock();
        Condition isNull = lock.newCondition();
        Condition isFull= lock.newCondition();
        LinkedList<Integer> list = new LinkedList<>();

        public SynQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        public void add(int val){
            try {
                lock.lock();
                try {
                    while (list.size()>=maxSize){
                        System.out.println("阻塞队列已满");
                        isFull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(val);
                isNull.signal();
            }finally {
                lock.unlock();
            }
        }

        public int get(){
            try {
                lock.lock();
                try {
                    while (list.size()==0){
                        System.out.println("阻塞队列为空");
                        isNull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int res = list.removeFirst();
                isFull.signal();
                return res;
            }finally {
                lock.unlock();
            }
        }
    }
}
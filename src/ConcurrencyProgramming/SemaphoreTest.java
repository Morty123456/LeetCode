package ConcurrencyProgramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wzh
 * @time: 2020/8/13 9:06
 * @description:
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static Semaphore s = new Semaphore(10);
    public static ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Lock lock = new ReentrantLock();
    public static AtomicInteger count = new AtomicInteger(1);
    public static volatile int n = 1;
    public static int k = 1;
    public static int synchronizedNum = 1;
    public static int lockNum = 1;
    public static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < THREAD_COUNT; i++) {
////            threadpool.execute(new Runnable() {
////                @Override
////                public void run() {
////                    try {
////                        s.acquire();
////                        System.out.println(count+ " save data");
////                        count.getAndIncrement();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////            });
////        }
//        for (int i=0;i<10;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j=0;j<100;j++){
//                        count.getAndIncrement();
////                        n++;
////                        k++;
////                        increatment();
////                        increatmentLock();
//                    }
//                    countDownLatch.countDown();
//                }
//            }).start();
//        }

        Thread previous = Thread.currentThread();
        for (int i=0;i<10000;i++){
            Thread thread = new Thread(new demo(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

//        countDownLatch.await();
        //原子类
//        System.out.println(count);
//        //volatile
//        System.out.println(">>>>> "+n);
//        //普通
//        System.out.println(k);
//        //synchronized
//        System.out.println(synchronizedNum);
//        //lock
//        System.out.println(lockNum);
//        threadpool.shutdown();
    }
    public static synchronized void increatment(){
        synchronizedNum++;
    }
    public static void increatmentLock(){
        lockNum++;
    }
    public static class demo implements Runnable{
        private Thread thread;
        public demo(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName());
            System.out.println(k++);
        }
    }
}

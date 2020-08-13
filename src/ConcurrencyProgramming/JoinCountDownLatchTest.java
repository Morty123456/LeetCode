package ConcurrencyProgramming;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wzh
 * @time: 2020/8/12 22:54
 * @description:
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        test2();
        test();
    }
    static CountDownLatch c = new CountDownLatch(2);
    public static void test2() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                c.countDown();
                System.out.println("2");
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }
    public static void test() throws InterruptedException {
        Thread parse1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse1 finished");
            }
        });
        Thread parse2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parse2 finish");
            }
        });
        parse1.start();
        parse2.start();
//        parse1.join();
//        parse2.join();
        System.out.println("全部完成");
    }
}

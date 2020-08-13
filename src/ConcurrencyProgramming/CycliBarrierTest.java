package ConcurrencyProgramming;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: wzh
 * @time: 2020/8/13 8:11
 * @description:
 */
public class CycliBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int a = cyclicBarrier.await();
                    System.out.println(a+" a");
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println("1");
            }
        }).start();
        try {
            int b = cyclicBarrier.await();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("2");
    }
}

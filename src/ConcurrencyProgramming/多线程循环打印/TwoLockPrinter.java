package ConcurrencyProgramming.多线程循环打印;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: wzh
 * @time: 2020/8/6 11:38
 * @description:
 */

public class TwoLockPrinter implements Runnable{
    private static final int PRINT_COUNT = 10;
    private final Object fontLock;
    private final Object thisLock;
    private final char printChar;
    public TwoLockPrinter(Object fontLock, Object thisLock, char printChar){
        this.fontLock = fontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }
    @Override
    public void run() {
        for (int i=0;i<PRINT_COUNT;i++){
            synchronized (fontLock){
                synchronized (thisLock){
                    System.out.println(printChar);
                    //本线程打印完之后唤醒等待的线程，因为只有一个在等待
                    thisLock.notify();
                }
                try {
                    //释放锁
                    fontLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (i<PRINT_COUNT-1){
//                    try {
//                        fontLock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        Object lockD = new Object();

        Thread threadA = new Thread(new TwoLockPrinter(lockD, lockA, 'A'));
        Thread threadB = new Thread(new TwoLockPrinter(lockA, lockB, 'B'));
        Thread threadC = new Thread(new TwoLockPrinter(lockB, lockC, 'C'));
        Thread threadD = new Thread(new TwoLockPrinter(lockC, lockD, 'D'));

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        Thread.sleep(100);
        threadD.start();
    }
}

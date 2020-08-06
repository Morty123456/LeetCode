package ConcurrencyProgramming.多线程循环打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wzh
 * @time: 2020/8/6 13:24
 * @description:
 */
public class RcSyncPrinter implements Runnable {
    private static final int PRINT_COUNT = 10;
    private final ReentrantLock reentrantLock;
    private final Condition nextCondition;
    private final Condition thisCondition;
    private final char printChar;

    public RcSyncPrinter(ReentrantLock reentrantLock, Condition nextCondition, Condition thisCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.nextCondition = nextCondition;
        this.thisCondition = thisCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.print(printChar);
                nextCondition.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printerA = new Thread(new RcSyncPrinter(lock, conditionA, conditionB, 'A'));
        Thread printerB = new Thread(new RcSyncPrinter(lock, conditionB, conditionC, 'B'));
        Thread printerC = new Thread(new RcSyncPrinter(lock, conditionC, conditionA, 'C'));
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();

    }
}

package ConcurrencyProgramming.Lock;

import ConcurrencyProgramming.utils.SleepUtils;
import javafx.concurrent.Worker;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    @Test
    public void test(){
        final TwinsLock lock = new TwinsLock();
        class Worker extends Thread{
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i=0;i<10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i=0;i<10;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
}

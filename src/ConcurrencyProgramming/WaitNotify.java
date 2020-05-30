package ConcurrencyProgramming;

import ConcurrencyProgramming.utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws Exception{
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }
    static class Wait implements Runnable{
        public void run(){
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+"flag is true. wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        //调用wait方法会释放锁
                        lock.wait();
                    }catch (InterruptedException e){
                    }
                }
                System.out.println(Thread.currentThread()+" flag is false. running @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock. notify @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                new SimpleDateFormat("HH:mm:ss").format(new Date());
                //通知所有等待该对象的线程
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again. sleep @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }


    }
}

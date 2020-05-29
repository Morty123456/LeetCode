package ConcurrencyProgramming;

import java.util.concurrent.TimeUnit;

public class ThreadState {
    public static void main(String[] args){
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
    //该线程不断地进行睡眠
    public static class TimeWaiting implements Runnable{
        @Override
        public void run(){
            while (true){
                SleepUtils.second(100);
            }
        }
    }
    //该线程在 Waiting.class 实例上等待
    public static class Waiting implements Runnable{
        @Override
        public void run(){
            while (true){
                synchronized (Waiting.class){
                    try{
                        //调用wait方法，线程进入等待状态
                        Waiting.class.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //该线程在 Blocked.class 上加锁后，不会释放该锁
    public static class Blocked implements Runnable{
        public void run(){
            synchronized (Blocked.class){
                while (true){
                    //超时等待（设置等待时间限制）
                    SleepUtils.second(100);
                }
            }
        }
    }
    public static class SleepUtils{
        public static final void second(long seconds){
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e){}
        }
    }
}

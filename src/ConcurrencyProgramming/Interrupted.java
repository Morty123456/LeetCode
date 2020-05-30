package ConcurrencyProgramming;

import ConcurrencyProgramming.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws Exception{
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread："+sleepThread.isInterrupted());
        System.out.println("BusyThread："+busyThread.isInterrupted());
    }
    static class SleepRunner implements Runnable{
        @Override
        public void run(){
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable{
        @Override
        public void run(){
            while (true){

            }
        }
    }
}

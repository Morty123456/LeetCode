package ConcurrencyProgramming;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //进行中断操作
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        //进行取消操作，通过改变boolean类型的值
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run(){
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i="+i);
        }
        public void cancel(){
            on = false;
        }
    }
}

package ConcurrencyProgramming;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws Exception{
        Thread previous = Thread.currentThread();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate.");
    }
    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread){
            this.thread = thread;
        }
        public void run(){
            try {
                //当前线程A等待thread线程终止之后才会从thread.join()返回，使线程按顺序执行
                thread.join();
            }catch (InterruptedException e){
            }
            System.out.println(Thread.currentThread().getName()+" terminate");
        }
    }
}

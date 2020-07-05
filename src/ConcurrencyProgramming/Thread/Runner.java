package ConcurrencyProgramming.Thread;

/**
 * @author: wzh
 * @time: 2020/7/5 9:32
 * @description:
 */
public class Runner implements Runnable {
    private long i;
    private volatile boolean on = true;
    @Override
    public void run() {
        //isInterrupted，查看线程是否被中断
        while (on && !Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println("Count i = "+i);
    }
    public void cancle(){
        on = false;
    }
}

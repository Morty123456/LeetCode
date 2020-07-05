package ConcurrencyProgramming.Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: wzh
 * @time: 2020/7/5 9:31
 * @description:
 */
//中断线程的两种方式，interrupt和boolean变量
public class shutDown {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one);
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        //中断线程
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two);
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancle();
    }
}

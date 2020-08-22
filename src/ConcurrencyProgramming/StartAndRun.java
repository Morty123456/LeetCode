package ConcurrencyProgramming;

/**
 * @author: wzh
 * @time: 2020/8/22 11:22
 * @description:
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
//        thread1.run();
//        thread2.run();
        thread1.start();
        thread2.start();
    }
}
class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程1进入运行状态……");
        }
    }
}
class Runner2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(">>>>>>>>>线程2进入运行状态……");
        }
    }
}
package ConcurrencyProgramming.多线程循环打印;

/**
 * @author: wzh
 * @time: 2020/8/5 22:08
 * @description:
 */
public class PrintABA {
    public static void main(String[] args){
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (number<=100){
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+" "+number+" ");
                number++;
                //notify将等待队列中的线程，拿到同步队列中
                notify();
                try {
//                    if (number<=100)
                        //此线程：释放锁；进入等待队列，变为WAITING状态
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+" 》》》》》》》 "+number);
    }
}
class Number3 implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (number<100){
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+" "+number);
                number++;
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
class Number2 implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
//                notifyAll();
                if (number<=100){
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+" "+number);
                    number++;
                    notifyAll();
                    try {
                        if (number<=100)
                            wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else
                    break;
            }
        }
    }
}

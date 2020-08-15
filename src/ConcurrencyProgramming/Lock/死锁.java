package ConcurrencyProgramming.Lock;

/**
 * @author: wzh
 * @time: 2020/8/15 16:03
 * @description:
 */
public class 死锁 {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(new SL(o1,o2,1));
        Thread thread2 = new Thread(new SL(o1,o2,2));
        thread1.start();
        thread2.start();
    }

    public static class SL implements Runnable{
        private Object o1;
        private Object o2;
        private int count;
        public SL(Object o1, Object o2, int count){
            this.o1 = o1;
            this.o2 = o2;
            this.count = count;
        }

        @Override
        public void run() {
            if (count==1){
                synchronized (o1){
                    try {
                        System.out.println("thread1 拿到 o1");
                        Thread.sleep(100);
                        synchronized (o2){
                            System.out.println("thread1 拿到 o2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                synchronized (o2){
                    try {
                        System.out.println("thread2 拿到 o2");
                        Thread.sleep(100);
                        synchronized (o1){
                            System.out.println("thread2 拿到 o1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

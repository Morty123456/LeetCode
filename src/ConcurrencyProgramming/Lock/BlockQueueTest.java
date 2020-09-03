package ConcurrencyProgramming.Lock;

/**
 * @author: wzh
 * @time: 2020/9/2 9:06
 * @description:
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        BlockQueue blockQueueSynchronized = new BlockQueue(5);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                blockQueueSynchronized.add(i);
                System.out.println("塞入 "+i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            while (true){
                int i = blockQueueSynchronized.take();
                System.out.println("弹出 "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

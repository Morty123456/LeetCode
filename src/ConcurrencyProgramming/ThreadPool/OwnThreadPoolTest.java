package ConcurrencyProgramming.ThreadPool;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wzh
 * @time: 2020/8/16 20:52
 * @description:
 */
public class OwnThreadPoolTest {
    public static void main(String[] args) throws IOException {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
//        executor.prestartAllCoreThreads();
        for (int i = 0; i <=10 ; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        System.in.read();
    }
    static class NameThreadFactory implements ThreadFactory{
        private final AtomicInteger mThread = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-"+mThread.getAndIncrement());
            System.out.println(t.getName()+" has been created");
            return t;
        }
    }
    static class MyIgnorePolicy implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r,executor);
        }
        public void doLog(Runnable r, ThreadPoolExecutor e){
            System.out.println(r.toString()+" rejected");
        }
    }
    static class MyTask implements Runnable{
        private String name;
        public MyTask(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(this.toString()+" is running!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name="+name+"]";
        }
    }
}

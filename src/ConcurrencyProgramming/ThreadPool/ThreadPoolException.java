package ConcurrencyProgramming.ThreadPool;

import java.util.concurrent.*;

/**
 * @author: wzh
 * @time: 2020/8/15 21:09
 * @description: 线程池内的线程出现异常怎么办
 */
public class ThreadPoolException {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        threadPool.submit(()->sayHi("submit"));
        threadPool.execute(()->sayHi("execute"));
        System.out.println("---------------------------");
        Future<?> future = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                sayHi("submit");
            }
        });
        try {
            System.out.println("future get str："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------");
        Future<?> futureByCallAbleSubmit = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                sayHi("callable");
                return "hi";
            }
        });
        System.out.println("callable return str："+ futureByCallAbleSubmit.get());
        System.out.println("-----------------------------------------");
        threadPool.shutdownNow();
    }
    public static void sayHi(String name){
        String returnStr = "this name:" + name;
        System.out.println(returnStr);
        throw new RuntimeException(returnStr+"--->Exception");
    }
}

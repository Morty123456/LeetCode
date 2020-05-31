package ConcurrencyProgramming;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    //新建一个连接池
    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有的ConnectionRunner可以同时开始
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;
    public static void main(String[] args) throws Exception{
        //需要的线程数量
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        //每个线程获取数据库连接的次数
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i=0;i<threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke："+(threadCount*count));
        System.out.println("got Connection："+got);
        System.out.println("not got Connection："+notGot);
    }
    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        public void run(){
            try {
                start.await();
            }catch (Exception ex){
            }
            while (count>0){
                try {
                    //1000ms之内获取不到，就返回null
                    Connection connection = pool.fetchConnection(1000);
                    //获取成功，got+1
                    if (connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            //释放连接
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }
                    //获取失败，notGot+1
                    else {
                        notGot.incrementAndGet();
                    }
                }catch (Exception ex){
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}

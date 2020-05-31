package ConcurrencyProgramming;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();
    public ConnectionPool(int initializeSize){
        if (initializeSize>0){
            for (int i=0;i<initializeSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }
    public void releaseConnection(Connection connection){
        if (connection!=null){
            synchronized (pool){
                //归还连接，把连接放到连接池最后
                //通知其他等待线程
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
    //获取连接
    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            if (mills<=0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis()+mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining>0){
                    pool.wait(remaining);
                    remaining = future-System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}

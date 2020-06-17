package ConcurrencyProgramming.Lock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

public class TwinsLock {
    //Sync：自定义同步器
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if (count<=0){
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }
        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount<0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current+returnCount;
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }
    public void lock(){
        sync.acquireShared(1);
    }
    public void unlock(){
        sync.releaseShared(1);
    }
}

package ConcurrencyProgramming;

import java.util.concurrent.TimeUnit;

public class Profiler {
    //ThreadLocal线程变量，以一个ThreadLocal对象为键，任意对象为值的存储结构
    public static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost："+Profiler.end()+" mils");
    }
}

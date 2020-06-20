package ConcurrencyProgramming;

public class ThteadLocal {
    public static void main(String[] args){
        Thread t = new Thread();
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
        threadLocal.set(2);
        System.out.println(threadLocal.get());
        new Thread(()->{
            threadLocal.set(1);
            System.out.println(threadLocal.get());
        }).start();

    }
}

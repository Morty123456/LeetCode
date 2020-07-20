package ConcurrencyProgramming;

public class ThteadLocal {
    public static void main(String[] args){
        Thread t = new Thread();
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        ThreadLocal<Integer> b = new ThreadLocal<>();
        threadLocal.set(1);
        b.set(1);
        System.out.println(threadLocal.get()+" "+b.get());
        System.out.println(threadLocal.get());
        new Thread(()->{
            threadLocal.set(2);

            System.out.println(threadLocal.get()+" "+b.get());
        }).start();
        System.out.println("aaa  "+threadLocal.get());
    }
}

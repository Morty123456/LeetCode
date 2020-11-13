package aa;

public class test12 {
    public static void main(String[] args) {
        ThreadLocal<Integer> a = new ThreadLocal<>();
        ThreadLocal<Integer> b = new ThreadLocal<>();
        a.set(1);
        b.set(2);
        new Thread(()->{
            a.set(3);
            System.out.println("新线程："+a.get());
        }).start();
        System.out.println("原线程："+a.get());
    }

}

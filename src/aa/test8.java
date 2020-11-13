package aa;

public class test8 {
    public static void main(String[] args) {
        int a = B.a;
    }
    static class A{
        A(){
            System.out.println("父类构造函数");
        }
        {
            System.out.println("父类代码段");
        }
        static{
            System.out.println("父类静态代码段");
        }
        static int a = 1;
        int b = 2;
    }
    static class B extends A{
        B(){
            System.out.println("子类构造函数");
        }
        {
            System.out.println("子类代码段");
        }
        static{
            System.out.println("子类静态代码段");
        }
    }
}

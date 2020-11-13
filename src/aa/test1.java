package aa;

public class test1 {
    public static void main(String[] args) {
        A aClass = new A();
        String s1= "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s3==s4);
        System.out.println(s1.equals(s2));
        System.out.println(s3.equals(s4));
        Integer a = new Integer(1);
        Integer b = 1;
        int bb = a.intValue();
        System.out.println(a+" "+bb);
    }
    static class A{
        public A() {
            System.out.println("构造方法");
        }
        {
            System.out.println("非静态代码块");
        }
        static {
            System.out.println("静态代码块");
        }
    }
}

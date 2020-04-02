package JVM;

public class staticDispatch {
    static abstract class Human{
    }
    static class Man extends Human{
    }
    static class Woman extends Human{
    }

    public void sayHello(Human guy){
        System.out.println("hello, guy");
    }
    public void sayHello(Man man){
        System.out.println("hello, gentleman");
    }
    public void sayHello(Woman woman){
        System.out.println("hello, lady");
    }

    public static void main(String[] args){
        Human man = new Man();
        Man woman = new Man();
        man = new Woman();
        staticDispatch sr = new staticDispatch();
        sr.sayHello(  man );
        sr.sayHello( woman );
    }
}

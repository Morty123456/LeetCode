package DesignPatten.danli;

public class test {
    public static void main(String[] args){
        for (int i=0;i<10;i++){
//            System.out.println(LHan.getInstance().hashCode());
//            new Thread(() -> System.out.println(LHan.getInstance().hashCode())).start();
//            new Thread(()->System.out.println(EHan.getInstance().hashCode())).start();
//            new Thread(() -> System.out.println(DoubleCheck.getInstance().hashCode())).start();
            new Thread(() -> System.out.println(StaticClass.getInstance().hashCode())).start();
        }
    }
}
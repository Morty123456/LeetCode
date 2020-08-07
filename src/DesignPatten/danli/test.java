package DesignPatten.danli;

import java.lang.reflect.Constructor;

public class test {
    public static void main(String[] args) throws Exception {
        for (int i=0;i<10;i++){
//            System.out.println(LHan.getInstance().hashCode());
//            new Thread(() -> System.out.println(LHan.getInstance2().hashCode())).start();
//            new Thread(()->System.out.println(EHan.getInstance().hashCode())).start();
//            new Thread(() -> System.out.println(DoubleCheck.getInstance().hashCode())).start();
//            new Thread(() -> System.out.println(StaticClass.getInstance().hashCode())).start();
        }
        //反射破坏 静态内部类 的单例模式
//        StaticClass staticClass = StaticClass.getInstance();
//        Class clzz = Class.forName("DesignPatten.danli.StaticClass");
//        Constructor<StaticClass> con = clzz.getDeclaredConstructor();
//        con.setAccessible(true);
//        StaticClass newStaticClass = con.newInstance();
//        System.out.println(staticClass==newStaticClass);

        DoubleCheck doubleCheck = DoubleCheck.getInstance();
        Constructor<DoubleCheck> doubleCheckConstructor = DoubleCheck.class.getDeclaredConstructor();
        doubleCheckConstructor.setAccessible(true);
        DoubleCheck newDouble = doubleCheckConstructor.newInstance();
        System.out.println(doubleCheck.hashCode()+" "+newDouble.hashCode());

        MeiJu.INSTANCE.anyMethod();
    }
}
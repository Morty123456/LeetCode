package DesignPatten.danli;

public class StaticClass {
    //静态内部类
    private static class SingletonHolder{
        private static final StaticClass instance = new StaticClass();
    }
    private StaticClass(){}
    public static final StaticClass getInstance(){
        return SingletonHolder.instance;
    }
}

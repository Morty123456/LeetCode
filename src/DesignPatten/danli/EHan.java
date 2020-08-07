package DesignPatten.danli;

public class EHan{
    //没有线程安全问题
    private static EHan instance = new EHan();
    private EHan(){}
    public static synchronized EHan getInstance(){
        return instance;
    }
}

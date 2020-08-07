package DesignPatten.danli;

public class LHan{
    private static LHan instance;
    private LHan(){}
    public static synchronized LHan getInstance(){
        if (instance==null)
            instance = new LHan();
        return instance;
    }
    public static LHan getInstance2(){
        synchronized (LHan.class){
            if (instance==null)
                instance = new LHan();
            return instance;
        }
    }
}
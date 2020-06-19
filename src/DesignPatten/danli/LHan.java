package DesignPatten.danli;

public class LHan {
    private static LHan instance;
    private LHan(){}
    //是否可以支持多线程，就看此处有没有synchronized关键字
    public synchronized static LHan getInstance(){
        if (instance==null)
            instance = new LHan();
        return instance;
    }
}

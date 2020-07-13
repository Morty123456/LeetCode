package DesignPatten.Single;

/**
 * @author: wzh
 * @time: 2020/7/14 6:28
 * @description:
 */
public class LHan {
    private static LHan instance;
    private LHan(){}
    //是否有 synchronized 关键字是懒汉是否安全的关键
    public synchronized static LHan getInstance(){
        if (instance==null)
            instance = new LHan();
        return instance;
    }
}

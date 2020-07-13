package DesignPatten.Single;

/**
 * @author: wzh
 * @time: 2020/7/14 6:28
 * @description:
 */
public class DoubleCheck {
    private volatile static DoubleCheck instance;
    private DoubleCheck(){};
    public static DoubleCheck getInstance(){
        if (instance==null){
            synchronized (DoubleCheck.class){
                if (instance==null)
                    instance = new DoubleCheck();
            }
        }
        return instance;
    }
}

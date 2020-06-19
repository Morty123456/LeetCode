package DesignPatten.danli;

public class DoubleCheck {
    private volatile static DoubleCheck instance;
    private DoubleCheck(){};
    public static DoubleCheck getInstance(){
        //判断对象是否被实例化过
        if (instance==null){
            synchronized (DoubleCheck.class){
                if (instance==null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}

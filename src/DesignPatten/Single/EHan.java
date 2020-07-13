package DesignPatten.Single;

/**
 * @author: wzh
 * @time: 2020/7/14 6:28
 * @description:
 */
public class EHan {
    //final防止被继承
    private static final EHan instance = new EHan();
    private EHan(){};
    public static EHan getInstance(){
        return instance;
    }
}

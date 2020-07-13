package DesignPatten.Single;

/**
 * @author: wzh
 * @time: 2020/7/14 6:28
 * @description:
 */
public class StaticClass {
    private static class Single{
        private static final StaticClass instance = new StaticClass();
    }
    private StaticClass(){}
    public static StaticClass getInstance(){
        return Single.instance;
    }
}

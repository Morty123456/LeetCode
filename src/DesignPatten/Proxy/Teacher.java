package DesignPatten.Proxy;

/**
 * @author: wzh
 * @time: 2020/7/8 21:32
 * @description:
 */
public class Teacher implements People {
    @Override
    public String work() {
        System.out.println("老师教书育人");
        return "教书";
    }

    @Override
    public void say(){
        System.out.println("我是个老师");
    }
}

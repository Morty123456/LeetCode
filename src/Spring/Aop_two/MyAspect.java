package Spring.Aop_two;

/**
 * @author: wzh
 * @time: 2020/8/21 9:52
 * @description:
 */
public class MyAspect {
    public void before(){
        System.out.println("鸡首");
    }
    public void after(){
        System.out.println("牛后");
    }
}

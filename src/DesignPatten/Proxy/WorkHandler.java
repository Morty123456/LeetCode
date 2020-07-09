package DesignPatten.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: wzh
 * @time: 2020/7/8 21:33
 * @description:
 */
//动态代理都必须实现 InvocationHandler 接口
public class WorkHandler implements InvocationHandler {
    //要代理的真实对象
    private Object obj;

    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    /*proxy：传入的代理实现类，在这里代理类和真实对象产生联系
    **method：调用对象真实的方法的method对象
    **args[]：代理对象方法传递的参数
    **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //再真实对象执行之间添加自己的操作
        System.out.println("before invoke");
        //实现被代理对象原有的方法
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke");
        return invoke;
    }
}

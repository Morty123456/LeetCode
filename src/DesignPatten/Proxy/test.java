package DesignPatten.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: wzh
 * @time: 2020/7/8 21:40
 * @description:
 */
public class test {
    public static void main(String[] args){
        //要代理的真实对象
        People people = new Teacher();

        //代理对象的调用程序，我们要把真实的对象传入代理对象的调用程序中的 构造函数中
        //最终代理对象的调用程序会调用真实对象的方法
        InvocationHandler handler = new WorkHandler(people);

        //通过 Proxy类的 newProxyInstance 的方法来创建代理对象
        //第一个参数：定义由哪个类加载器对生成的代理类进行加载
        //第二个参数：给代理类对象提供一组什么样的接口
        //第三个参数：当动态代理对象调用方法时，会关联到哪一个代理对象上

        //newProxyInstance产生的实例可以被强转成 people，说明在这个方法里，我们的代理类应该继承或实现了专门创建的接口，这样才把两个类连接起来
        //在需要 继承proxy类获取有关方法 和 InvocationHandler构造方法传参  时，java不能同时继承两个类，想要和代理类建立联系，只能实现接口
        People proxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);

        System.out.println(proxy.work());
    }
}

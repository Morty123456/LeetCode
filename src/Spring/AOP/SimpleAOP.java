package Spring.AOP;

import java.lang.reflect.Proxy;

/**
 * @author: wzh
 * @time: 2020/7/8 20:26
 * @description:
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice){
        //创建一个代理对象
        //定义哪个类加载器对生成的代理类进行加载
        //定义给代理对象提供一组什么接口
        //当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}

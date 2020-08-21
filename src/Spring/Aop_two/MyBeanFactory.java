package Spring.Aop_two;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wzh
 * @time: 2020/8/21 9:53
 * @description:
 */
public class MyBeanFactory {
    public static UserService createService(){
        //目标类
        UserService userService = new UserServiceImpl();
        //切面类
        MyAspect myAspect = new MyAspect();
        /*
        代理类：将目标类 和 切面类 结合
        Proxy.newProxyInstance 的三个参数
        loader：类加载器，动态代理类运行时创建，任何类都需要类加载将其加载到内存
            可选参数：当前类.class.getClassLoader()
                     目标类实例.getClass().getClassLoader()
        Class[] interfaces：代理类需要实现的所有接口
            方式1：目标类实例.getClass.getInterfaces()  //这样做只能获得自己的接口，不能获得父元素的接口
            方式2：new Class[]{UserService.class}
        InvocationHandler：动态代理类的调用处理程序，需要重写 invoke 方法，代理类的每一个方法执行时，都会调用一次 invoke
            参数1：Object proxy：代理对象
            参数2：Method method：代理对象当前执行的方法的描述对象
                    执行方法名：method.getName()
                    执行方法：method.invoke(对象，实际参数)
            参数3：Object[] args：方法实际参数
         */
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.before();
                        Object obj = method.invoke(userService, args);
                        myAspect.after();
                        return obj;
                    }
                });
        return proxyService;
    }
}

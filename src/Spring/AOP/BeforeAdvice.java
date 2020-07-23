package Spring.AOP;

import java.lang.reflect.Method;

/**
 * @author: wzh
 * @time: 2020/7/8 20:23
 * @description:
 */
//实现前置通知
public class BeforeAdvice implements Advice {
    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }
    //重写invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标方法前调用通知
        methodInvocation.invoke();
        Object invoke = method.invoke(bean, args);
        return invoke;
    }
}

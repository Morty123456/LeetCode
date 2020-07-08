package Spring.AOP;

import java.lang.reflect.InvocationHandler;

/**
 * @author: wzh
 * @time: 2020/7/8 20:22
 * @description:
 */
//每一个动态代理程序 都必须实现 InvocationHandler 接口
public interface Advice extends InvocationHandler {
}

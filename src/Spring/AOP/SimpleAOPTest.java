package Spring.AOP;

import org.junit.Test;

/**
 * @author: wzh
 * @time: 2020/7/8 20:29
 * @description:
 */
public class SimpleAOPTest {
    @Test
    public void getProxy() throws Exception{
        MethodInvocation logTask = ()->System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        HelloService helloServiceImplProxy = (HelloService)SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceImplProxy.sayHelloWord();
    }
}

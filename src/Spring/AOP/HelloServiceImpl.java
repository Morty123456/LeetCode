package Spring.AOP;

/**
 * @author: wzh
 * @time: 2020/7/8 20:28
 * @description:
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHelloWord(){
        System.out.println("hello word");
    }
}

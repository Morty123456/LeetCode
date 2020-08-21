package Spring.Aop_two;

import org.junit.Test;

/**
 * @author: wzh
 * @time: 2020/8/21 10:01
 * @description:
 */
public class SimpleAop {
    @Test
    public void getProxy(){
        UserService userService = MyBeanFactory.createService();
        userService.addUser();
    }
}

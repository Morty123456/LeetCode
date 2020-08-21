package Spring.Aop_two;

/**
 * @author: wzh
 * @time: 2020/8/21 9:55
 * @description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加");
    }

    @Override
    public void updateUser() {
        System.out.println("更新");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除");
    }
}

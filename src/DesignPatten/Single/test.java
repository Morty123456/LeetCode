package DesignPatten.Single;

/**
 * @author: wzh
 * @time: 2020/7/14 6:28
 * @description:
 */
public class test {
    public static void main(String[] args){
        for (int i=0;i<100;i++){
//            new Thread(() -> System.out.println(LHan.getInstance().hashCode())).start();
//            new Thread(() -> System.out.println(EHan.getInstance().hashCode())).start();
//            new Thread(() -> System.out.println(DoubleCheck.getInstance().hashCode())).start();
            new Thread(() -> System.out.println(StaticClass.getInstance().hashCode())).start();
        }
    }
}

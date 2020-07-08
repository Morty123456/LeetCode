package Spring.IOC;

/**
 * @author: wzh
 * @time: 2020/7/8 14:23
 * @description:
 */
public class SimpleIOCTest {
    public static void main(String[] args) throws Exception{
        String location = SimpleIOC.class.getClassLoader().getResource("Spring/IOC/ioc.xml").getFile();
//        System.out.println(location);
//        String location = "ioc.xml";
        SimpleIOC df = new SimpleIOC(location);
        Wheel wheel = (Wheel)df.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car)df.getBean("car");
        System.out.println(car);
    }
}

package JVM.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author: wzh
 * @time: 2020/7/5 20:20
 * @description:
 */
public class Reflect {
    public static void main(String[] args) throws Exception{
//        fanshe();
//        Constructors();
//        Field();
//        Method();
//        MethodMain();
        fanxing();
    }
    //获取class对象
    public static void fanshe(){
        //第一种，已经得到对象了，就不必使用反射
        Student stu1 = new Student();
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());
        //需要导入依赖，依赖性太强
        Class stuClass2 = Student.class;
        System.out.println(stuClass2.getName());
        System.out.println(stuClass2.equals(stuClass));
        //最常用，带包名的路径
        try {
            Class stuClass3 = Class.forName("JVM.Reflect.Student");
            System.out.println(stuClass3 == stuClass2);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //获取构造方法
    public static void Constructors() throws Exception{
        //加载class对象
        Class clazz = Class.forName("JVM.Reflect.Student");
        //所有的公有构造方法
        System.out.println("------------所有共有构造方法----------------");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray){
            System.out.println(c);
        }
        //所有的构造方法
        System.out.println("------------所有构造方法----------------");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray){
            System.out.println(c);
        }
        //获取公有无参构造方法
        System.out.println("------------公有无参构造方法----------------");
        Constructor con = clazz.getConstructor(null);
        System.out.println("con="+con);
        Object obj = con.newInstance();
        System.out.println("obj="+obj);
        //获取私有构造方法，并调用
        System.out.println("------------私有构造方法----------------");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println("con="+con);
//        con.setAccessible(true);
        obj = con.newInstance('男');
    }
    //获取字段
    public static void Field() throws Exception{
        //获取Class对象
        Class stuClass = Class.forName("JVM.Reflect.Student");
        //获取字段
        System.out.println("--------获取公有字段------------------");
        Field[] fields = stuClass.getFields();
        for (Field field : fields)
            System.out.println(field);
        System.out.println("--------获取所有字段------------------");
        fields = stuClass.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println("--------获取公有字段并调用------------------");
        Field f = stuClass.getField("name");
        System.out.println(f);
        Object object = stuClass.getConstructor().newInstance();
        f.set(object, "刘德华");
        Student student = (Student)object;
        System.out.println(student.name);
        System.out.println("--------获取私有字段并调用------------------");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);
        f.set(object, "19887668678");
        System.out.println(student);
    }
    //获取成员方法
    public static void Method() throws Exception{
        //获取class对象
        Class stuClass = Class.forName("JVM.Reflect.Student");
        System.out.println("------------获取所有公有方法--------------");
        Method[] methods = stuClass.getMethods();
        for (Method method : methods)
            System.out.println(method);
        System.out.println("------------获取所有方法--------------");
        methods = stuClass.getDeclaredMethods();
        for (Method m : methods)
            System.out.println(m);
        System.out.println("------------获取公有的show1方法--------------");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        Object object = stuClass.getConstructor().newInstance();
        //invoke就是调用method的方法，在这里就是调用m方法
        m.invoke(object,"刘德华");
        System.out.println("------------获取私有的show4方法--------------");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);
        //下面的Object是返回值
        Object re = m.invoke(object, 20);
        System.out.println(re);
    }
    //获取main方法
    public static void MethodMain() throws Exception{
        //获取student字节码对象
        Class clazz = Class.forName("JVM.Reflect.Student");
        //获取main方法
        Method methodMain = clazz.getMethod("main", String[].class);
        methodMain.invoke(null, (Object)new String[]{"a","b","c"});
    }
    //越过泛型检查
    public static void fanxing() throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        Class listClass = strList.getClass();
        Method method = listClass.getMethod("add", Object.class);
        method.invoke(strList, "100");
        for (Object obj : strList)
            System.out.println(obj);
    }
}

package JVM.Reflect;

/**
 * @author: wzh
 * @time: 2020/7/5 20:16
 * @description:
 */
public class Student {
    Student(String str){
        System.out.println("默认构造方法,str="+str);
    }
    public Student(){
        System.out.println("无参构造方法");
    }
    public Student(char name){
        System.out.println("姓名:"+name);
    }
    public Student(String name, int age){
        System.out.println("姓名："+name+"年龄："+age);
    }
    protected Student(boolean n){
        System.out.println("受保护的构造方法,n="+n);
    }
    private Student(int age){
        System.out.println("私有构造方法，年龄："+age);
    }

    //字段
    public String name;
    protected int age;
    char sex;
    private String phoneNum;
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    //成员方法
    public void show1(String s){
        System.out.println("调用了公有的，String参数的show1：s="+s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2");
    }
    void show3(){
        System.out.println("调用了默认的，无参的show3");
    }
    private String show4(int age){
        System.out.println("调用了私有的，有返回值的，int参数的show4");
        return "abc";
    }
    //main方法
    public static void main(String[] args){
        System.out.println("main方法执行了……");
    }
}

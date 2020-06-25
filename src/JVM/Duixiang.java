package JVM;

/**
 * @author: wzh
 * @time: 2020/6/25 21:08
 * @description:
 */
public class Duixiang {
    public static void main(String[] args){
        String s = "abc";
        String ss = "abc";
        String sss = new String("abc");
        System.out.println(s==ss);
        //String每次更改，都会新建一个对象
        s = s+'d';
        System.out.println(s==ss);
        System.out.println(s);
        System.out.println(ss);
        System.out.println(sss);
    }
}

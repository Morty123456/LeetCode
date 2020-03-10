package BroadView;

//不用加减乘除实现加法
public class ex65_add {
    public static void main(String[] args){
        System.out.println(add(2,3));
    }
    public static int add(int a, int b){
        while (b!=0){
            int plus = (a^b);
            b = ((a & b)<<1);
            a = plus;
        }
        return a;
    }
}

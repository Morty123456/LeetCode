package BroadView.SecondTime;

public class ex_65_add {
    public static void main(String[] args){
        System.out.print(add(1,2));
    }
    public static int add(int a, int b){
        while (b!=0){
            int c = (a&b)<<1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

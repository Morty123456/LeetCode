package BroadView.SecondTime;

public class myPow {
    public static void main(String[] args){
        System.out.println(myPow(2, -2147483648));
    }
    public static double myPow(double x, int n){
        long b = n;
        boolean flage = true;
        if (b<0){
            x = 1/x;
            b *= -1;
        }
        double sum = 1;
        while (b>0){
            if ((b&1)!=0){
                sum *= x;
            }
            x *= x;
            b >>= 1;
        }
        return sum;
    }
    //超出时间限制
    public static double myPow2(double x, int n){
        double sum = 1;
        while (n>0){
            sum *= x;
            n--;
        }
        while (n<0){
            sum /= x;
            n++;
        }
        return sum;
    }
}

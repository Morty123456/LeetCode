package BroadView;
//除了dp，还可以找规律
//见leetcode解析
public class ex14_cutTheRop {
    public static void main(String[] args){
        System.out.println(tanxin(90));
    }
//    dp
    public static int dp(int m){
        int[] cut = new int[m+1];
        cut[2]=2;
        cut[3]=3;
        for (int i=4;i<=m;i++){
            for (int j=1;j<=i/2;j++){
                cut[i] = Math.max(cut[i], cut[j]*cut[i-j]);
            }
        }
        return cut[m];
    }
    public static int tanxin(int n){
        if(n<=3) return n-1;
        int a=n/3;
        int b=n%3;
        long rep;
        if(b==0)
            rep = power(3,a);
        else if(b==1)
            rep = power(3,a-1)*4 % 1000000007;
        else
            rep =  power(3,a)*2 % 1000000007;
        return (int)rep;
    }
    public static long power(int a, int b){
        long sum=1;
        while(b-->0){
            sum = sum * a % 1000000007;
        }
//        System.out.println("sum  ："+sum);
        return sum;
    }
}

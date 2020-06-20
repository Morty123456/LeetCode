package BroadView.SecondTime;

public class ex_66_constructArr {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] dp = constructArr(a);
        for (int d : dp){
            System.out.print(d+" ");
        }
    }
    public static int[] constructArr(int[] a){
        int length = a.length;
        int[] dp = new int[length];
        dp[0]=1;
        //第一轮循环，计算对角线左下角的部分
        for (int i=1;i<length;i++){
            dp[i] = dp[i-1] * a[i-1];
        }
        //第二轮循环，计算对角线右上角的部分
        //temp标记位，计算从右到对角线的乘积
        int temp = 1;
        for (int i=length-2;i>=0;i--){
            temp *= a[i+1];
            dp[i] *= temp;
        }
        return dp;
    }
}

package BroadView.SecondTime;

import java.math.BigInteger;

public class cuttingRope {
    public static void main(String[] args){
        System.out.println(cuttingRope(120));
    }
    public static int cuttingRope(int n){
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        BigInteger[] dp = new BigInteger[n+1];
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for(int i=4;i<=n;i++){
            dp[i] = new BigInteger("0");
            for (int j=i/2;j<i;j++){
                dp[i] = dp[i].max(dp[j].multiply(dp[i-j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }
}

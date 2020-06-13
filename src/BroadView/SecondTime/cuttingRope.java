package BroadView.SecondTime;

import java.util.Map;

public class cuttingRope {
    public static void main(String[] args){
        System.out.println(cuttingRope(10));
    }
    public static int cuttingRope(int n){
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=2;dp[3]=3;
        for(int i=4;i<=n;i++){
            int max = 0;
            for (int j=i/2;j<i;j++){
                max = Math.max(max,dp[j]*dp[i-j]);
            }
            dp[i]=max;
        }
        return dp[n];
    }
}

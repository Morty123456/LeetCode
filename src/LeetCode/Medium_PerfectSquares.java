package LeetCode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Medium_PerfectSquares {
    public static void main(String[] args){
        int n = 12;
        System.out.println(numSquare2(n));
    }
    public static int numSquares(int n){
        int[] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = n+1;
        }
        for (int i=0;i<=n;i++){
            if (i*i <= n)
                dp[i*i]=1;
            else
                break;
        }
        for (int i=1;i<=n;i++){
            for (int j=i-1;j>=1;j--){
                dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
            }
        }
        return dp[n];
    };
    public static int numSquare2(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for (int i=0;i<=n;i++)
            for (int j=1;i+j*j<=n;j++)
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
        return dp[n];
    }
}

package LeetCode;

public class Medium_waysToChange {
    public static void main(String[] args){
        System.out.print(waysToChange(25));
    }
    public static int waysToChange(int n){
        int[] dp = new int[n+1];
        int[] coins = {25,10,5,1};
        dp[0] = 1;
        for (int c=0;c<4;++c){
            int coin = coins[c];
            for (int i=coin;i<=n;i++)
                dp[i] = (dp[i]+dp[i-coin])%1000000007;
        }
        return dp[n];
    }
}

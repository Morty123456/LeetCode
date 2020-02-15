package LeetCode;

import java.util.Arrays;

//计算找零需要的最小硬币数
public class Medium_CoinChange {
    public static void main(String[] args){
        int[] nums = {474, 83, 404, 3};
        System.out.println(coinChange(nums, 264));
    }
    public static int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int length = coins.length;
        int[] dp = new int[amount+1];
        for (int i=1;i<=amount;i++)
            dp[i] = amount+1;
        for (int i=0;i<length;i++)
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
        for (int i=1;i<=amount;i++){
            for (int j=length-1;j>=0;j--){
                if (i>=coins[j])
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        if (dp[amount] == amount+1)
            return -1;
        else
            return dp[amount];
    }
}

package LeetCode;

import java.util.Arrays;

public class Medium_CoinExchange {
    public static void main(String[] args){
        int[] coins = {474,83,404,3};
        Arrays.sort(coins);
        int amount  = 264;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount){
        if (amount==0)
            return 0;
        int[] count = new int[amount+1];
        for(int i=0;i<=amount;i++)
            count[i] = amount+1;
        for (int coin : coins)
            if (coin<=amount)
                count[coin] = 1;
        for (int i = 2*coins[0];i<=amount;i++){
            for (int coin : coins){
                if (i-coin>=0 && i<=amount)
                    count[i] = Math.min(count[i], count[i-coin]+1);
            }
        }
        if (count[amount]==amount+1)
            return -1;
        return count[amount];
    }
}

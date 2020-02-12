package LeetCode;

public class Medium_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args){
        int[] nums = {1,2,3,0,2};
        System.out.print(maxProfit1(nums));
    }
    public static int maxProfit(int[] prices){
        int length = prices.length;
        int[] s0 = new int[length];
        int[] s1 = new int[length];
        int[] s2 = new int[length];
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i=1;i<length;i++){
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]);
            s2[i] = s1[i-1]+prices[i];
        }
        return Math.max(s0[length-1], s2[length-1]);
    }
    public static int maxProfit1(int[] prices){
        if (prices.length==0)
            return 0;
        int length = prices.length;
        int[] buy = new int[length+1];
        int[] sell = new int[length+1];
        buy[1] = -prices[0];
        for (int i=2;i<=length;i++){
            buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i-1]);
        }
        return sell[length];
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/30 7:59
 * @description:
 */
public class A_shares {
    public static void main(String[] args) {
        int[] num = {3,3,5,0,0,3,1,4};
        System.out.println(shares1(num));
        System.out.println(shares2(num));
        System.out.println(shares3(num));
        System.out.println(shares4(num, 2));
    }
    public static int shares1(int[] prices){
        /**
         *  这一天股票数为 0 的时候，上一天只能是 不变 或者 卖出
         *  T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1]+prices[i])
         *  这一天股票数为 1 的时候，上一天只能是 不变 或者 买入，买入后交易次数-1
         *  T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0]-prices[i])
         *  T[i-1][0][0]=0
         */
        if (prices.length==0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len-1][0];
    }

    public static int shares2(int[] prices){
        /**
         *  只有买入的操作，才会改变 k 值
         *  T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
         *  T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
         */
        if (prices.length==0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[length-1][0];
    }

    public static int shares3(int[] prices){
        /**
         *  T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
         *  T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
         *  T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
         *  T[i][1][1] = max(T[i-1][1][1], T[i-1][0][0] - prices[i])
         */
        if (prices.length==0)
            return 0;
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]);
        }
        return dp[len-1][2][0];
    }

    public static int shares4(int[] prices, int k){
        if (prices==null || prices.length==0)
            return 0;
        int len = prices.length;
        //因为每次股票交易都至少需要两天，所以如果交易次数大于股票价格数组的一半，就可以认为进行无数次交易
        if (k >= len/2){
            return shares2(prices);
        }
        int[][][] dp = new int[len][k+1][2];
        for (int i=1;i<=k;i++){
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i <len ; i++) {
            for (int j = k; j >=1 ; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}

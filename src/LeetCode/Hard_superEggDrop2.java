package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/2 17:14
 * @description:
 */
public class Hard_superEggDrop2 {
    public static void main(String[] args) {
        int k = 2, n = 100;
        int[][] memo = new int[k+1][n+1];
        System.out.println(dp(k, n, memo));
    }

    /**
     *
     * @param k：鸡蛋个数
     * @param n：楼层高度
     * @param memo：备忘录，用来记录 k,n 时需要扔鸡蛋的次数
     * @return：需要扔的次数
     */
    public static int dp(int k, int n, int[][] memo){
        if (k==1){
            memo[k][n] = n;
            return n;
        }
        if (n==0){
            memo[k][n] = 0;
            return 0;
        }
        if (memo[k][n]!=0)
            return memo[k][n];
        int res = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){
            res = Math.min(res, Math.max(dp(k-1, i-1, memo), dp(k, n-i, memo))+1);
        }
        memo[k][n] = res;
        return res;
    }
}

package aa;

public class test36 {
    public static void main(String[] args) {
        System.out.println(solve(6,2));
    }
    public static int solve(int n, int k){
        // n个楼层，k个鸡蛋
        int[][] dp = new int[n+1][k+1];
        // 只有 0 或 1 层楼的时候
        for (int i=0; i<=k; i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        // 只有 0 或 1 个鸡蛋的时候
        for (int i=0; i<=n; i++){
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i=2; i<=n; i++){
            for (int j=2; j<=k; j++){
                int min = Integer.MAX_VALUE;
                for (int h=1; h<=i; h++){
                    min = Math.min(min, Math.max(dp[h-1][j-1], dp[i-h][j])+1);
                }
                dp[i][j] = min;
            }
        }
        return dp[n][k];
    }
}

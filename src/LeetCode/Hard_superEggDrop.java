package LeetCode;

public class Hard_superEggDrop {
    public static void main(String[] args){
        System.out.println(superEggDrop(2,100));
    }
    public static int superEggDrop(int K, int N){
        int[][] dp = new int[K+1][N+1];
        int res = dp(K,N,dp);
        return res;
    }
    public static int dp(int k, int n, int[][] memo){
        if (k==1){
            memo[k][n]=n;
            return n;
        }
        if (n==0){
            memo[k][n]=0;
            return 0;
        }
        if (memo[k][n]!=0)
            return memo[k][n];
        int res = Integer.MAX_VALUE;
//        for (int i=1;i<=n;i++){
//            res = Math.min(res, Math.max(dp(k,n-i, memo), dp(k-1,i-1, memo))+1);
//        }
//      优化成为二分查找
        int lo=1, hi=n;
        while (lo<=hi){
            int mid = (lo+hi)/2;
            int broken = dp(k-1, mid-1, memo);
            int not_broken = dp(k, n-mid, memo);
            if (broken>not_broken){
                hi = mid-1;
                res = Math.min(res, broken+1);
            }
            else {
                lo = mid+1;
                res = Math.min(res, not_broken+1);
            }
        }
        memo[k][n] = res;
        return res;
    }
}

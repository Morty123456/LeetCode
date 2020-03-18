package BroadView;

public class ex49_nthUglyNumber {
    public static void main(String[] args){
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int p0=0, p1=0, p2=0;
        for (int i=1;i<n;i++){
            dp[i] = Math.min(dp[p0]*2, Math.min(dp[p1]*3, dp[p2]*5));
            if (dp[i]==dp[p0]*2)
                p0++;
            if (dp[i]==dp[p1]*3)
                p1++;
            if (dp[i]==dp[p2]*5)
                p2++;
        }
        return dp[n-1];
    }
}

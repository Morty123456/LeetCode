package BroadView.SecondTime;

public class ex_60_twoSum {
    public static void main(String[] args){
        double[] res = twoSum(1);
        for (double r : res)
            System.out.println(r);
    }
    public static double[] twoSum(int n){
        int[][] dp = new int[n+1][6*n+1];
        for (int i=1;i<=6;i++)
            dp[1][i]=1;
        //dp[i][j] = dp[i-1][j-1]+dp[i-1][j-2]+......+dp[i-1][j-6]
        for (int i=1;i<=n;i++){
            for (int j=i;j<=6*i;j++){
                for (int cur=1;cur<=6;cur++){
                    if (j-cur<=0)
                        break;
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
        double[] res = new double[6*n-n+1];
        double sum = Math.pow(6, n);
        for (int i=n;i<=6*n;i++){
            res[i-n] = (dp[n][i]/sum);
        }
        return res;
    }
}

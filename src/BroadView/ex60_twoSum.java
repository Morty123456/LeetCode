package BroadView;

public class ex60_twoSum {
    public static void main(String[] args){
        double[] gailu = twoSum(2);
        for (double a : gailu)
            System.out.println(a);
    }
    public static double[] twoSum(int n){
        double[][] dp = new double[n+1][6*n+1];
        for (int i=1;i<=6;i++)
            dp[1][i]=1;
        for (int i=2;i<=n;i++){
            for (int j=i;j<=6*i;j++){
                for (int d=1;d<=6;d++){
                    if (j-d >= i-1)
                        dp[i][j] += dp[i-1][j-d];
                }
            }
        }
        double[] gaiu = new double[5*n+1];
        double sum = 0;
        for (double num : dp[n])
            sum += num;
        System.out.println(sum);
        for (int i=n;i<=    6*n;i++){
            System.out.println(dp[n][i]);
            gaiu[i-n] = dp[n][i]/sum;
        }
        return gaiu;
    }
}

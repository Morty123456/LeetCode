package NowCoder.guanglianda;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/19 18:24
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] power = new double[n+1];
        int[] happy = new int[n+1];
        for (int i=1;i<=n;i++){
            power[i] = sc.nextDouble();
            happy[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][m+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (j-power[i]>=0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-(int)power[i]] + happy[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int i = 0;
        System.out.println(dp[n][m]);
    }
}

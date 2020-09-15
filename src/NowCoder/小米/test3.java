package NowCoder.小米;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/15 19:42
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        solution(num);
    }
    public static void solution(int[] num){
        int len = num.length;
        int sum = 0;
        for (int n : num)
            sum += n;
        /**
         * dp[i][j]表示前i件物品中，总和最接近j的所有物品总和
         * 其中包括两种情况：第i件物品没有包括其中；第i件物品包括其中
         * 如果第i件物品没有包括其中，则 dp[i][j] = dp[i-1][j]
         * 如果第i件物品包括其中，则 dp[i][j] = dp[i-1][j-num[i]]+num[i]
         */
        int[][] dp = new int[len+1][sum/2+1];
        for (int i=0;i<len;i++){
            for (int j=1;j<=sum/2;j++){
                dp[i+1][j] = dp[i][j];
                if (num[i]<=j && dp[i][j-num[i]]+num[i]>dp[i][j]){
                    dp[i+1][j] = dp[i][j-num[i]]+num[i];
                }
            }
        }
        int a = dp[len][sum/2];
        int b = sum-a;
        System.out.println(a*b);
    }
}

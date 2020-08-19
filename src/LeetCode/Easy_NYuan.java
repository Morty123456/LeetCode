package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/19 15:27
 * @description:
 */
public class Easy_NYuan {
    public static void main(String[] args) {
        System.out.println(hetNum(4));
    }
    public static int hetNum(int n){
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i] = 1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i] = dp[i]+dp[i-j];
            }
        }
        return dp[n];
    }
}

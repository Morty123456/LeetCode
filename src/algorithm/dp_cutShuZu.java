package algorithm;

/**
 * @author: wzh
 * @time: 2020/8/8 18:15
 * @description:
 */
public class dp_cutShuZu {
    public static void main(String[] args){
        int[] dp = {1,1,4,3};
        System.out.println(canPartition(dp));
    }
    public static boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum%2==1)
            return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums){
            for (int i=sum;i>=num;i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[sum];
    }
}

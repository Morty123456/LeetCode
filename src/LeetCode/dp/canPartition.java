package LeetCode.dp;

/**
 * @author: wzh
 * @time: 2020/8/10 22:34
 * @description:
 */
public class canPartition {
    public static void main(String[] args) {
        int[] nums = {100};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum%2==1)
            return false;
        int target = sum/2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target+1];
        if (nums[0]<=target)
            dp[0][nums[0]] = true;
        for (int i=1;i<len;i++){
            for (int j=0;j<=target;j++){
                if (j==nums[i])
                    dp[i][j] = true;
                if (j>nums[i])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
            }
        }
        return dp[len-1][target];
    }
}

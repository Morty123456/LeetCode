package LeetCode;

import java.util.Map;

/**
 * @author: wzh
 * @time: 2020/7/5 8:53
 * @description:
 */
public class Medium_rob {
    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        //不抢第一家
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        int max1 = dp[nums.length];
        //不抢最后一家
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[0];
        for (int i=2;i<nums.length;i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i-1], dp2[i-1]);
        }
        int max2 = dp2[nums.length-1];
        return Math.max(max1, max2);
    }
}

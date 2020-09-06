package LeetCode;

import java.util.Arrays;

/**
 * @author: wzh
 * @time: 2020/9/6 8:14
 * @description:
 */
public class Medium_lengthOfLIS2 {
    public static void main(String[] args) {
        int[] num = {0};
        System.out.println(lengthOfLIS(num));
    }
    public static int lengthOfLIS(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

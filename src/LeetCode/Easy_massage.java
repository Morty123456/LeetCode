package LeetCode;

public class Easy_massage {
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(massage(nums));
    }
    public static int massage(int[] nums){
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=2;i<dp.length;i++){
            dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}

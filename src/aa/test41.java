package aa;

public class test41 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(solution(nums));
    }
    public static boolean solution(int[] nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum%2==1)
            return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<=target; j++){
                if (nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}

package LeetCode;

public class Medium_lengthOfLIS {
    public static void main(String[] args){
        int[] num = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(num));
    }
    public static int lengthOfLIS(int[] nums){
        if (nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        for (int i=0;i<nums.length;i++)
            dp[i] = 1;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int max = 0;
        for (int d: dp)
            max = d>max ? d : max;
        return max;
    }
}

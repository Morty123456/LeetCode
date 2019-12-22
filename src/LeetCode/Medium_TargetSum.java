package LeetCode;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: 一个数组通过计算是否可以得到某个结果
 * @author: wzh
 * @create: 2019-12-22 13:28
 **/
public class Medium_TargetSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++)
            nums[i] = sc.nextInt();
        int S = sc.nextInt();
        System.out.println(findTargetSumWaysDp(nums, S));
    }
    //dp，动态规划算法
    //转化为求解一个数组中，和为S的取值有多少种
    public static int findTargetSumWaysDp(int[] nums, int S){
        if (nums.length==0)
            return 0;
        int sum = 0;
        for (int num:nums)
            sum+=num;
        if (sum<S || sum<-S || (sum+S)%2==1)
            return 0;
        int find = (sum+S)/2;
        int[] dp = new int[find+1];
        dp[0] = 1;
        for (int num : nums){
            for (int i=find;i>=num;i--)
                dp[i] += dp[i-num];
        }
        return dp[find];
    }
    //递归实现
    public static int findTargetSumWays(int[] nums, int S){
        int sum = 0;
        int i = 0;
        int count = 0;
        count = solution(nums, S, sum, i, count);
        return count;
    }
    public static int solution(int[] nums, int S, int sum, int i, int count){
        if (i==nums.length){
            if (sum == S)
                count++;
        }
        else {
            count = solution(nums, S, sum+(nums[i]), i+1, count);
            count = solution(nums, S, sum-(nums[i]), i+1, count);
        }
        return count;
    }
}

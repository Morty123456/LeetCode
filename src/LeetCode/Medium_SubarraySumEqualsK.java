package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Medium_SubarraySumEqualsK {
    public static void main(String[] args){
        int[] nums = {-1,1,1};
        int k = 0;
        System.out.println(subarraySum3(nums, k));
    }
    //第一个方法不太对
    public static int subarraySum(int[] nums, int k){
        int count = 0;
        int sum = 0;
//        int sum = nums[0];
//        if (sum==k)
//            count++;
        for (int i=0, j=0;i<nums.length;i++){
            if (sum<k)
                sum += nums[i];
            if (sum==k){
                count++;
                sum -= nums[j];
                j++;
            }
            while (sum>k && j<=i){
                sum -= nums[j];
                j--;
                if (sum==k)
                    count++;
            }
        }
        return count;
    }
    //两次循环
    public static int subarraySum2(int[] nums, int k){
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1;i<nums.length;i++)
            sum[i] = sum[i-1]+nums[i];
        for (int i=0;i<sum.length;i++){
            if (sum[i]==k)
                count++;
            for (int j=0;j<i;j++){
                if (sum[i]-sum[j]==k)
                    count++;
            }
        }
        return count;
    }
    //使用HashMap减少时间复杂度
    public static int subarraySum3(int[] nums, int k){
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums){
            sum += num;
            result += preSum.getOrDefault(sum-k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}

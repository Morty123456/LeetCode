package LeetCode;

import java.util.Arrays;

/**
 * @author: wzh
 * @time: 2020/6/24 7:58
 * @description:最近三数之和
 */
public class Medium_threeSumClosest {
    public static void main(String[] args){
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0;i<3;i++)
            sum += nums[i];
        int res = sum;
        //利用双指针
        for (int i=0;i<nums.length-2;i++){
            //左指针
            int left = i+1;
            //右指针
            int right = nums.length-1;
            while (left<right){
                //计算和
                sum = nums[i]+nums[left]+nums[right];
                if (Math.abs(sum-target)<Math.abs(res-target))
                    res = sum;
                if (sum < target){
                    left++;
                }
                else if (sum > target){
                    right--;
                }else {
                    return target;
                }
            }
        }
        return res;
    }
}

package LeetCode;

import java.util.HashMap;

public class Easy_canThreePartsEqualSum {
    public static void main(String[] args){
//        int[] nums = {0,2,1,-6,6,-7,9,1,2,0,1};
        int[] nums = {1,2};
        HashMap map = new HashMap();
        System.out.println(canThreePartsEqualSum(nums));
    }
    public static boolean canThreePartsEqualSum(int[] nums){
        int length = nums.length;
        int left = 1, right = length-2;
        int sum = getSun(nums, 0, length-1);
        int leftSum = nums[0];
        while (leftSum!=sum/3 && left<right){
            leftSum += nums[left];
            left++;
        }
        int rightSum = nums[length-1];
        while (rightSum!=sum/3 && right>left){
            rightSum += nums[right];
            right--;
        }
        int midSum = getSun(nums, left, right);
        if(midSum == leftSum)
            return true;
        return false;
    }
    public static int getSun(int[] nums, int begin, int end){
        int sum = 0;
        for (int i=begin;i<=end;i++)
            sum += nums[i];
        return sum;
    }
}

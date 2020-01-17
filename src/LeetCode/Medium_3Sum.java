package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * program: LeetCode
 * description: 找到和为零的集合
 * Author: wzh
 * create: 2020-01-16 20:03
 */
public class Medium_3Sum {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> slist = threeSum(nums);
        for (List a : slist)
            System.out.println(a.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length<3)
            return list;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i>0 && nums[i]==nums[i-1])
                continue;
            findZero(list, nums,i+1, nums.length-1,nums[i]);
        }
        return list;
    }
    public static void findZero(List<List<Integer>> list, int[] nums, int begin, int end, int target){
        int l = begin;
        int r = end;
        while (l<r){
            if (nums[l]+nums[r]+target==0){
                List<Integer> res = new ArrayList<>();
                res.add(target);
                res.add(nums[l]);
                res.add(nums[r]);
                list.add(res);
                while (l<r && nums[l]==nums[l+1])
                    l++;
                while (l<r && nums[r]==nums[r-1])
                    r--;
                l++;
                r--;
            }
            else if (nums[l]+nums[r]+target<0)
                l++;
            else
                r--;
        }
    }
    public static int findMid(int[] nums, int left, int right){
        int mid = (left+right)/2;
        if (nums[mid]*nums[mid+1]<=0)
            return mid;
        else if (nums[mid]>0)
            return findMid(nums, left, mid);
        else
            return findMid(nums, mid, right);
    }
}

package LeetCode;

import java.util.*;

public class Medium_threeSum {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> li : list)
            System.out.println(li.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0;i<len;i++){
            if (nums[i]>0)
                break;
            if (i>0 && nums[i]==nums[i-1])
                continue;
            int l = i+1;
            int r = len-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0){
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l<r && nums[l]==nums[l+1])
                        l++;
                    while (l<r && nums[r]==nums[r-1])
                        r--;
                    l++;
                    r--;
                }
                else if (sum>0)
                    r--;
                else
                    l++;
            }
        }
        return list;
    }
}

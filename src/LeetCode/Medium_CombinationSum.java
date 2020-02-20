package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Medium_CombinationSum {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        for (List<Integer> li : res)
            System.out.println(li.toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new LinkedList<>();
        if (candidates==null)
            return res;
        Arrays.sort(candidates);
        getCombinations(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public static void getCombinations(List<List<Integer>> res, List<Integer> list,int[] nums, int target, int pos){
        if (target<0)
            return;
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=pos;i<nums.length;i++){
            if (nums[i]>target)
                break;
            if (i>pos && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            getCombinations(res, list, nums, target-nums[i], i);
            list.remove(list.size()-1);
        }
    }
}

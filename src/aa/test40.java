package aa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test40 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        int i = 0;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        for(int i=0; i<len-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<len-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left = j+1;
                int right = len-1;
                while(left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left]==nums[left+1]) left++;
                        while(left < right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }else if(sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}

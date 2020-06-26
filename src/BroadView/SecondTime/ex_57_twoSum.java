package BroadView.SecondTime;

import java.util.HashSet;

/**
 * @author: wzh
 * @time: 2020/6/26 18:35
 * @description:
 */
public class ex_57_twoSum {
    public static void main(String[] args){
    }
    public static int[] twoSum(int[] nums, int target){
        HashSet<Integer> hashSet = new HashSet<>();
        int[] res = new int[2];
        for (int num : nums){
            if (hashSet.contains(target-num)){
                res[0] = num;
                res[1] = target-num;
            }
            hashSet.add(num);
        }
        return res;
    }
}

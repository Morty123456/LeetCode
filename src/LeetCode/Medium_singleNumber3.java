package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/4 17:32
 * @description:
 */
public class Medium_singleNumber3 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = singleNumber(nums);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] singleNumber(int[] nums){
        int num = nums[0];
        for (int i=1;i<nums.length;i++){
            num ^= nums[i];
        }
        int count = 1;
        while((count&num)==0){
            count <<= 1;
        }
        int[] res = new int[2];
        for (int n : nums){
            if ((n&count) == 0){
                res[0] ^= n;
            }else{
                res[1] ^= n;
            }
        }
        return res;
    }
}

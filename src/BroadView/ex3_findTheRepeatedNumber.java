package BroadView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * program: LeetCode
 * description: 找到数组中任意一个重复数字  P39
 * Author: wzh
 * create: 2020-01-30 09:52
 */
//排序，Hash表
//还有这种方法
public class ex3_findTheRepeatedNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i=0;i<length;i++)
            nums[i] = sc.nextInt();
        System.out.println(findRepeatedHash(nums));
    }
    public static int findRepeatedNumber(int[] nums){
        int length = nums.length;
        for (int i=0;i<length;){
            while (i<length && nums[i]!=i){
                if (nums[nums[i]] == nums[i])
                    return nums[i];
                else{
                    int a = nums[nums[i]];
                    nums[nums[i]]=nums[i];
                    nums[i] = a;
                }
            }
            i++;
        }
        return 0;
    }
    public static int findRepeatedHash(int[] nums){
        int length = nums.length;
        HashSet hash = new HashSet();
        for (int i=0;i<length;i++){
            if (hash.contains(nums[i]))
                return nums[i];
            else
                hash.add(nums[i]);
        }
        return 0;
    }
}

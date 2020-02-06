package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * program: LeetCode
 * description: 改变数字的位置，使值增加
 * Author: wzh
 * create: 2020-02-05 18:51
 */
public class Medium_NextPermutation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] num = new int[n];
//        for (int i=0;i<n;i++)
//            num[i] = sc.nextInt();
        int[] num = {3,1,2};
        nextPermutation2(num);
        for (int a: num)
            System.out.println(a);
    }
    public static void nextPermutation(int[] nums){
        int length = nums.length;
        if (length<=1)
            return;
        for (int i=length-1;i>=0;i--){
            int minloca = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j=i;j<length;j++){
                if (nums[j]>nums[i] && nums[j]<=minValue){
                    minloca = j;
                    minValue = nums[j];
                }
            }
            if (minloca!=-1){
                int target = nums[i];
                nums[i] = nums[minloca];
                nums[minloca] = target;
                Arrays.sort(nums,i+1,length);
                return;
            }
        }
        change(nums);
        return;
    }
    public static void change(int[] nums){
        int length = nums.length;
        int left = 0, right = length-1;
        while (left<=right){
            int target = nums[left];
            nums[left] = nums[right];
            nums[right] = target;
            left++;
            right--;
        }
        return;
    }
//答案和自己的想法比，减去了很多无效的比较，复杂度应该是少了一个数量级
    public static void nextPermutation2(int[] nums){
        if (nums==null || nums.length<=1)
            return;
        int i = nums.length-2;
        //下面这个while停止之前的，从左到右降序排列
        while (i>=0 && nums[i]>=nums[i+1])
            i--;
        //如果i=-1,说明数组是按降序排列的，直接翻转就可以
        //如果不是全为降序
        if (i>=0){
            int j = nums.length-1;
            //从右往左找，第一个大于此数字的，就是比他大的最小值
            while (nums[j] <= nums[i])
                j--;
            //两位置交换之后，两位置之间的还是降序排列
            //翻转一下变为升序的
            swap(nums,i,j);
        }
        reverse(nums,i+1, nums.length-1);
    }
    public static void swap(int[] nums, int i, int j){
        int target = nums[i];
        nums[i] = nums[j];
        nums[j] = target;
    }
    public static void reverse(int[] nums, int i, int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }
}

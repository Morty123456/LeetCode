package BroadView.SecondTime;

import java.util.LinkedList;

/**
 * @author: wzh
 * @time: 2020/6/23 17:29
 * @description:
 */
public class ex_59_maxSlidingWindow {
    public static void main(String[] args){
        int[] nums = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow(nums, 3);
        for (int r : res)
            System.out.print(r+" ");
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        int maxLocal = 0;
        for (int i=0;i<k;i++)
            maxLocal = nums[i]>=nums[maxLocal]?i:maxLocal;
        for (int i=k;i<nums.length;i++){
            res[i-k] = nums[maxLocal];
            if (nums[i]>=nums[maxLocal])
                maxLocal = i;
            else if (i-k>=maxLocal){
                maxLocal = i-k+1;
                for (int j=i-k+1;j<=i;j++){
                    maxLocal = nums[j]>=nums[maxLocal]?j:maxLocal;
                }
            }else{}
        }
        res[nums.length-k] = nums[maxLocal];
        return res;
    }
}

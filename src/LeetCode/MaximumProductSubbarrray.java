package LeetCode;

import java.util.Scanner;

/**
 * program: LeetCode
 * description: 乘积最大的数组
 * Author: wzh
 * create: 2020-01-30 08:32
 */
public class MaximumProductSubbarrray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i=0;i<length;i++)
            nums[i] = sc.nextInt();
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        int[] f = new int[length];
        int[] g = new int[length];
        f[0] = g[0] = nums[0];
        for (int i=1;i<length;i++){
            f[i] = Math.max(Math.max(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }
}

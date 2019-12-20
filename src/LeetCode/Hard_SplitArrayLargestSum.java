package LeetCode;

import java.util.Scanner;

/**
 * program: LeetCode
 * description: 数组子序列的最大值
 * Author: wzh
 * create: 2019-12-20 15:17
 */
public class Hard_SplitArrayLargestSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
            max += a[i];
            if (min>a[i])
                min=a[i];
        }
        int m = solve(a, min, max, 3);
        System.out.println(m);
    }
    public static int solve(int[] a,int left, int right, int segement){
        if (left>right)
            return right+1;
        int mid = (left+right)/2;
        if (judge(a, mid, segement))
            return solve(a, left, mid-1, segement);
        else
            return solve(a, mid+1, right, segement);
    }
    public static boolean judge(int[] a, int mid, int segement){
        int sum = 0;
        int s = 0;
        for (int i=0;i<a.length;i++){
            sum += a[i];
            if (sum>mid){
                sum = a[i];
                s++;
            }
        }
        if (s>=segement)
            return false;
        else
            return true;
    }
}

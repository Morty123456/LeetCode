package LeetCode;

import java.util.Scanner;

/**
 * program: LeetCode
 * description: 数组子序列的最大值最小化
 * Author: wzh
 * create: 2019-12-20 15:17
 */
public class Hard_SplitArrayLargestSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int segement = sc.nextInt();
        int[] a = new int[n];
        long max = 0;
        long min = 0;
        for (int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
            max += a[i];
            min = Math.max(min, a[i]);
        }
        long m = solve(a, min, max, segement);
        System.out.println(m);
    }
    public static long solve(int[] a,long left, long right, int segement){
        if (left>right)
            return right+1;
        long mid = (left+right)/2;
        if (judge(a, mid, segement))
            return solve(a, left, mid-1, segement);
        else
            return solve(a, mid+1, right, segement);
    }
    public static boolean judge(int[] a, long mid, int segement){
        long sum = 0;
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

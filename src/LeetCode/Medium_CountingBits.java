package LeetCode;

import java.util.Scanner;

/**
 * program: LeetCode
 * description: 计算二进制中1的个数
 * Author: wzh
 * create: 2020-02-03 09:40
 */
public class Medium_CountingBits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] count = countBits(a);
        for (int b : count)
            System.out.println(b);
    }
    public static int[] countBits(int num){
        int[] count = new int[num+1];
        for (int i=0;i<=num;i++)
            count[i]=getCount(i);
        return count;
    }
    public static int getCount(int num){
        int res = 0;
        while (num!=0 && num!=1){
            if (num%2==1){
                res++;
            }
            num = num/2;
        }
        if (num==1)
            res++;
        return res;
    }
}

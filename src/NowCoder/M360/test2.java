package NowCoder.M360;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/22 18:48
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i=0;i<N;i++)
            num[i] = i+1;
        int M = sc.nextInt();
        int[] move = new int[M];
        for (int i = 0; i < M; i++) {
            move[i] = sc.nextInt();
        }
        int i=0;
        while (i < move.length){
            if (move[i]==2 && i+1<move.length && move[i+1]==2){
                i += 2;
            }
            else if (move[i]==1){
                int now = 1;
                while (i+1<move.length && move[i+1]==1){
                    i++;
                    now++;
                }
                now = now%N;
                if (now>0)
                    swap1(num, now);
                i++;
            }
            else if (move[i]==2){
                swap2(num);
                i++;
            }
        }
        for (int n : num)
            System.out.print(n + " ");
    }
    public static void swap1(int[] nums, int n){
        int[] sw = new int[n];
        for (int i=0;i<n;i++)
            sw[i] = nums[i];
        for (int i=0;i<nums.length-n;i++){
            nums[i] = nums[i+n];
        }
        for (int i=nums.length-n;i<nums.length;i++){
            nums[i] = sw[i-(nums.length-n)];
        }
    }
    public static void swap2(int[] nums){
        for (int i=0;i<nums.length;i+=2){
            nums[i] = (nums[i]+nums[i+1])-(nums[i+1]=nums[i]);
        }
    }
}

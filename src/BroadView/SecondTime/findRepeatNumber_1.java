package BroadView.SecondTime;

import java.util.Scanner;

public class findRepeatNumber_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        System.out.println(findRepeatNumber(num));
    }
    public static int findRepeatNumber(int[] nums){
        //整体思路，把每个数字都放在对应的位置上
        for (int i=0;i<nums.length;i++){
            //如果此位置的数字和下表不同，就一直交换
            while (nums[i]!=i){
                //如果此处的值作为下标的位置，和此处的值进行交换
                if (nums[nums[i]]==nums[i]){
                    return nums[i];
                }else {
                    nums[i] = nums[i]+nums[nums[i]]-(nums[nums[i]]=nums[i]);
                }
            }
        }
        return -1;
    }
}

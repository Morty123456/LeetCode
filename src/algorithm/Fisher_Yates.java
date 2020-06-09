package algorithm;

import java.util.Random;

public class Fisher_Yates {
    public static void main(String[] args){
        int[] num = new int[10];
        for (int i=0;i<10;i++){
            num[i] = i;
        }
        fish_yates(num);
        for (int n : num){
            System.out.print(n+" ");
        }
    }
    public static void fish_yates(int[] nums){
        for (int i=nums.length-1;i>0;i--){
            int rand = (new Random()).nextInt(i+1);
            nums[i] = nums[i]+nums[rand]-(nums[rand]=nums[i]);
        }
    }
}

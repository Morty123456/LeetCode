package NowCoder.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/19 18:24
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] num = new long[4];
        for (int i=0;i<=3;i++)
            num[i] = sc.nextLong();
        Arrays.sort(num);
        while (num[0]!=0 && !judge(num)){
            if (num[3]-num[2]>=2){
                num[3] -= 2;
                num[0] += 1;
            }else{
                num[3]--;
                num[2]--;
                num[0]++;
            }
            Arrays.sort(num);
        }
        if (judge(num))
            System.out.println(4*num[0]);
        else
            System.out.println("-1");
    }
    public static boolean judge(long[] nums){
        if(nums[0]==nums[1] && nums[1]==nums[2] && nums[2]==nums[3])
            return true;
        else
            return false;
    }
}

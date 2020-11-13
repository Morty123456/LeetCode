package aa;

import java.util.Arrays;
import java.util.Scanner;

public class test49 {
    public static void main(String[] args) {
        long[] nums = new long[4];
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<4; i++){
            nums[i] = sc.nextLong();
        }
        System.out.println(solution(nums));
    }
    public static long solution(long[] nums){
        Arrays.sort(nums);
        long a = nums[3];
        long b = nums[2];
        long c = nums[1];
        long d = nums[0];
        long x = 0;
        if (a>=(5*b-2*c-2*d)){
            x = a+2*b+2*c+2*d;
            if (x%7==0)
                return (4*x/7);
            else
                return (-1);
        }else if (a<(5*b-2*c-2*d) && a>(4*c-2*d-b)){
            x = a+b+2*c+2*d;
            if (x%6==0)
                return (x*4/6);
            else
                return (-1);
        }else if (a<=(4*c-2*d-b)){
            x = a+b+c+2*d;
            if (x%5==0)
                return (x*4/5);
            else
                return (-1);
        }else
            return (-1);
    }
}

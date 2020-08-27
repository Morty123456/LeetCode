package NowCoder.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/27 19:24
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n+1][2*n];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=2*i-1 ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(nums));
    }
    public static int solution(int[][] nums){
        for (int i=nums.length-2;i>=1;i--){
            for (int j=1;j<=2*i-1;j++){
                nums[i][j] += Math.max(nums[i+1][j], Math.max(nums[i+1][j+1], nums[i+1][j+2]));
            }
        }
        return nums[1][1];
    }
}

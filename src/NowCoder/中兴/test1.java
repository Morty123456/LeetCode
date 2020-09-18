package NowCoder.中兴;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/17 10:51
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[][] num = new int[n][3];
        for (int i=0; i<n; i++){
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
            num[i][2] = sc.nextInt();
        }
        int up = 0;
        int down = 0;
        for (int[] one : num){
            int x = one[0];
            int y = one[1];
            if (y > m*x+c)
                up += one[2];
            else
                down += one[2];
        }
        System.out.println(Math.max(up, down));
    }
}

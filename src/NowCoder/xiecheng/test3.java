package NowCoder.xiecheng;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/8 19:30
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int now = sc.nextInt();
        int addNum = sc.nextInt();
        int maxPower = sc.nextInt();
        int[][] power = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                power[i][j] = sc.nextInt();
            }
        }
        System.out.println("NA");
    }
}

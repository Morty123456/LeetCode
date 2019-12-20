package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * program: LeetCode
 * description: 矩阵中的最大子矩阵
 * Author: wzh
 * create: 2019-12-20 14:27
 */
public class dp_MaxMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[][]{
                {0,-2,-7,0},
                {9,2,-6,2},
                {-4,1,-4,1},
                {-1,8,0,2},
        };
        int a = findMaxInMatrix(matrix);
        System.out.println(a);
    }
    public static int findMaxInMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[] num = new int[col];
        //二维矩阵中子矩阵最大值->一维数组子序列最大值
        //通过把二维矩阵各列相加得到一维数组
        for (int i=0;i<row;i++){
            //初始化num数组
            for (int g=0;g<col;g++)
                num[g] = 0;

            for (int j=i;j>=0;j--){
                for (int k=0;k<col;k++)
                    num[k] += matrix[j][k];
                max = Math.max(max, findMaxInNum(num));
            }
        }
        return max;
    }
    public static int findMaxInNum(int[] num){
        int max = 0;
        int sum = 0;
        for (int i=0;i<num.length;i++){
            sum += num[i];
            if (sum>max)
                max=sum;
            if (sum<0)
                sum=0;
        }
        return max;
    }
}

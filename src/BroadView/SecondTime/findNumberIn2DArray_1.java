package BroadView.SecondTime;

import java.util.Scanner;

public class findNumberIn2DArray_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(findNumberIn2DArray(num, 20));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0, j = col-1;
        while (i<row && j>=0){
            if (matrix[i][j]==target)
                return true;
            else if (matrix[i][j]<target)
                i++;
            else
                j--;
        }
        return false;
    }
}

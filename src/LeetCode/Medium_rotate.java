package LeetCode;

public class Medium_rotate {
    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        rotate(matrix);
        for (int[] a: matrix){
            for (int aa:a)
                System.out.print(aa+" ");
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix){
        //先对折，再按照对角线进行翻转
        int n = matrix.length;
        if (n==0)
            return;
        int top = 0, down = n-1;
        while (top < down) {
            for (int i = 0; i < n; i++) {
                matrix[down][i] = matrix[down][i] + matrix[top][i] - (matrix[top][i] = matrix[down][i]);
            }
            top++;
            down--;
        }
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                matrix[i][j] = matrix[i][j]+matrix[j][i] - (matrix[j][i]=matrix[i][j]);
            }
        }
        return;
    }
}

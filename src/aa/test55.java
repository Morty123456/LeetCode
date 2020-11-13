package aa;

import java.util.Scanner;

public class test55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                num[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                res[i][j] = num[j][i];
            }
        }
        for (int i=n; i>=0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println(res[i][n]);
        }
    }
}

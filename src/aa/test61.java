package aa;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class test61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j = 0; j<n; j++){
                num[i][j] = sc.nextInt();
            }
        }
        for (int i=n-1; i>=0; i--){
            for (int j=n-1; j>=1; j--){
                System.out.print(num[i][j]+" ");
            }
            System.out.println(num[i][0]);
        }
    }
}

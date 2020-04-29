package NowCoder;

import java.util.Scanner;

public class zh1_1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tail = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                tail[i][j]=sc.nextInt();
            }
        }
        for (int i=n-1;i>=1;i--){
            for (int j=1;j<=i;j++){
                tail[i][j] += Math.max(tail[i+1][j-1], tail[i+1][j+1]);
            }
        }
        System.out.println(tail[1][1]);
    }
}

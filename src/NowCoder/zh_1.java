package NowCoder;

import java.util.Scanner;

public class zh_1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tail = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                tail[i][j]=sc.nextInt();
            }
        }
        int sum = getMax(1,1,n,tail);
        System.out.println(sum);
//        for (int[] a:tail){
//            for (int aa: a){
//                System.out.print(aa);
//            }
//            System.out.println();
//        }

    }
    public static int getMax(int x, int y, int n, int[][] tail){
        int now = tail[x][y];
        if (x==n)
            return now;
        else if (y==1)
            return now+getMax(x+1, y+1, n, tail);
//        else if (y==x){
//            return now+getMax(x+1,y-1,n, tail);
//        }
//        if (y<n && x>1 && x<y)
        else
            return Math.max(now+getMax(x+1, y-1, n, tail), now+getMax(x+1,y+1, n, tail));
    }
}

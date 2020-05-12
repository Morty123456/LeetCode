package NowCoder;

import java.util.HashSet;
import java.util.Scanner;

public class meituan_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] scores = new int[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                scores[i][j] = sc.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int j=0;j<m;j++){
            int max = 0;
            for(int i=0;i<n;i++)
                max = max<scores[i][j]?scores[i][j]:max;
            for (int i=0;i<n;i++){
                if (max==scores[i][j])
                    hashSet.add(i);
            }
        }
        System.out.print(hashSet.size());
    }
}

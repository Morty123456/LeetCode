package NowCoder.beike;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: wzh
 * @time: 2020/9/7 14:49
 * @description:
 */
public class test3 {
    public static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=1; i<=T; i++){
            sum = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            Set<Integer>[] canNot = new Set[m+1];
            for (int j = 1; j <= m; j++) {
                canNot[j] = new HashSet<>();
                for (int l = 1; l <= k; l++) {
                    canNot[j].add(sc.nextInt());
                }
            }
            System.out.println(solution(n, m, k, canNot));
        }
    }
    public static int solution(int n, int m, int k, Set[] canNot){
        for (int i=1;i<=m;i++){
            dfs(n, 1, m, i, canNot);
        }
        return sum%100000007;
    }
    public static void dfs(int sumLength, int nowLocal, int colorSum, int nowColor,  Set[] canNot){
        if (sumLength==nowLocal){
            sum++;
            return;
        }
//        System.out.println(nowColor);
        Set<Integer> nowColorCanNot = canNot[nowColor];
        for (int i=1; i<=colorSum; i++){
            if (nowColorCanNot!=null && nowColorCanNot.contains(i))
                continue;
            dfs(sumLength, nowLocal+1, colorSum, i, canNot);
        }
    }
}

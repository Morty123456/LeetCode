package NowCoder.beike;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/9/7 16:15
 * @description:
 */
public class test5 {
    public static int[] sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sum = new int[T+1];
        for (int i=1; i<=T; i++){
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
            System.out.println(solution(n, m, k, canNot, i));
        }
    }
    public static int solution(int n, int m, int k, Set[] canNot, int T){
        for (int i=1; i<=m; i++){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            dfs(n, m, list, canNot, T);
        }
        return sum[T];
    }
    public static void dfs(int sumLength, int colorSum, LinkedList list, Set[] canNot, int T){
        if (sumLength==list.size()){
            sum[T]++;
            return;
        }
        Set<Integer> nextColorCanNot = canNot[(int)list.getLast()];
        for (int i=1; i<=colorSum; i++){
            if (nextColorCanNot!=null && nextColorCanNot.contains(i))
                continue;
            list.add(i);
            dfs(sumLength, colorSum, list, canNot, T);
            list.removeLast();
        }
        return;
    }
}

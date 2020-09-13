package NowCoder.滴滴;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/9/13 19:00
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0){
            int n = sc.nextInt();
            int m  =sc.nextInt();
            int k = sc.nextInt();
            int[][] cost = new int[m][3];
            for (int i=0;i<m;i++){
                cost[i][0] = sc.nextInt();
                cost[i][1] = sc.nextInt();
                cost[i][2] = sc.nextInt();
            }
            if (solution(cost, n, k))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static boolean solution(int[][] cost, int land, int money){
        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2]==o2[2] && o1[0]==o2[0])
                    return o1[1]-o2[1];
                else if (o1[2]==o2[2])
                    return o1[0]-o2[0];
                return o1[2]-o2[2];
            }
        });
        for (int i=0;i<cost.length;i++){
            if (judge(cost, land, money, i)){
                return true;
            }
        }
        return false;
    }
    public static boolean judge(int[][] cost, int land, int money, int begin){
        if (cost[begin][2]>money)
            return false;
        Set<Integer> set = new HashSet<>();
        set.add(cost[begin][0]);
        set.add(cost[begin][1]);
        for (int i=begin; i<cost.length; i++){
            if (cost[i][2]<=money && set.contains(cost[i][0]))
                set.add(cost[i][1]);
        }
        return set.size()==land;
    }
}

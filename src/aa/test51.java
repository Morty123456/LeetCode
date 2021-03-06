package aa;

import java.util.Arrays;

public class test51 {
    public static void main(String[] args) {
        int[][] clips  = {
                {0,2},
                {4,6},
                {8,10},
                {1,9},
                {1,5},
                {5,9}
        };
        System.out.println(solution(clips, 10));
    }
    public static int solution(int[][] clips, int T){
        int[] dp = new int[T+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i<=T; i++){
            for (int[] clip : clips){
                if (clip[0]<i && i<=clip[1]){
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE ? -1 : dp[T];
    }
}

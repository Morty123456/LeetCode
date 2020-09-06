package NowCoder.xiaohongshu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 18:52
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int l = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        System.out.println(solution(x, l, t, num));
    }
    public static int solution(int x, int l, int t, int[] num){
        int step = l*t;
        num[0] = num[0]%step;
        HashSet<Integer> set = new HashSet<>();
        set.add(num[0]);
        for (int i=1;i<num.length;i++){
            if (num[i]-num[i-1] > step){
                num[i] = (num[i]-num[i-1])%step + num[i-1];
            }
            set.add(num[i]);
        }
        x = (x - num[num.length-1])%step + num[num.length-1];
        int[] dp = new int[x+1];
        boolean[] visited = new boolean[x+1];
        for (int i=l;i<=t;i++){
            visited[i] = true;
            if (set.contains(i))
                dp[i] = 1;
        }
        for (int i=t+1; i<=x; i++){
            int min = x;
            for (int j=l; j<=t; j++){
                if (!visited[i-j])
                    continue;
                visited[i] = true;
                if (min > dp[i-j])
                    min= dp[i-j];
            }
            if (set.contains(i))
                min++;
            dp[i] = min;
        }
        return dp[x];
    }
}

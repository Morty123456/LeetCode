package NowCoder.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: wzh
 * @time: 2020/9/12 14:17
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String man = sc.nextLine();
        String woman = sc.nextLine();
        int sum = sc.nextInt();
        int[][] heart = new int[sum][2];
        for (int i=0; i<sum; i++){
            heart[i][0] = sc.nextInt();
            heart[i][1] = sc.nextInt();
        }
        System.out.println(solution(heart));
    }
    static int maxSum = 0;
    static int sum = 0;
    static HashSet<Integer> man = new HashSet<>();
    static HashSet<Integer> woman = new HashSet<>();
    public static int solution(int[][] heart){
        dfs(heart, 0, -1, -1);
        return maxSum;
    }
    public static void dfs(int[][] heart, int start, int mPre, int wPre){
        for (int i=start; i<heart.length; i++){
            int m = heart[start][0];
            int w = heart[start][1];
            if(m==mPre || w==wPre)
                continue;
            if (!man.contains(m) && !woman.contains(w)){
                man.add(m);
                woman.add(w);
                sum++;
                maxSum = Math.max(maxSum, sum);
                dfs(heart, i+1, m, w);
                man.remove(m);
                woman.remove(w);
                sum--;
            }
        }

    }
}

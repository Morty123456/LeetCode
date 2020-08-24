package NowCoder.M360;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/24 10:59
 * @description:
 */
public class test4 {
    static int maxValue = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] num = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        //m个英雄
        boolean[] hero = new boolean[m];
        //n把武器
        int gan = n;
        //最大战斗力
        int nowValue = 0;
        solution(num, hero, nowValue, gan);
        System.out.println(maxValue);
    }
    public static void solution(int[][] num, boolean[] hero, int nowValue, int gan){
        if (gan==0)
            return;
        int m = num.length;
        int n = num[0].length;
        for (int i = 0; i < m; i++) {
            if (hero[i])
                continue;
            for (int j = 0; j < n; j++) {
                //剩余武器数足够
                if (gan>=j+1){
                    nowValue += num[i][j];
                    if (nowValue > maxValue)
                        maxValue = nowValue;
                    gan -= (j+1);
                    hero[i] = true;
                    solution(num, hero, nowValue, gan);
                    gan += (j+1);
                    nowValue -= num[i][j];
                    hero[i] = false;
                }
            }
        }
    }
}

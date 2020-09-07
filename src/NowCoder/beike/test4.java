package NowCoder.beike;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/7 14:49
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] kill = new int[n];
        int[] get = new int[n];
        for (int i=0;i<n;i++)
            kill[i] = sc.nextInt();
        for (int i=0;i<n;i++)
            get[i] = sc.nextInt();

    }
    public static int solution(int[] kill, int[] get, int n){
        int right = n/2;
        int left = right-1;
        int begin = 0;
        return 0;
    }
}

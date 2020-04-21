package NowCoder;

import DesignPatten.ResponsibilityChain.Majordomo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wangyi_niuniuFindJob {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] job = new int[N][2];
        for (int i=0;i<N;i++){
            job[i][0] = sc.nextInt();
            job[i][1] = sc.nextInt();
        }
        int[] ability = new int[M];
        for (int i=0;i<M;i++)
            ability[i] = sc.nextInt();
        int[] income = new int[M];
        Arrays.sort(job, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return (o1[0]-o2[0]);
            }
        });
        for (int i=0;i<M;i++){
            int j=0;
            income[i]=0;
            while (j<N && ability[i]>=job[j][0]){
                income[i] = Math.max(income[i], job[j][1]);
                j++;
            }

        }
        for (int in : income)
            System.out.println(in);
    }
}

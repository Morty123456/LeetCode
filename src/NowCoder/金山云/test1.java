package NowCoder.金山云;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/16 18:48
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1; i<=n; i++)
            solution(i);
    }
    public static void solution(int num){
        if (num==1){
            System.out.println(1);
            return;
        }
        if (num==2){
            System.out.println("1 1 1");
            return;
        }
        int[] n = new int[num];
        n[0] = 1;
        n[1] = 1;
        for (int i=2; i<num; i++){
            n[i] = n[i-1]+n[i-2];
        }
        for (int i=0; i<num; i++)
            System.out.print(n[i] + " ");
        for (int i=num-2; i>0; i--)
            System.out.print(n[i] + " ");
        System.out.println(1);
    }
}

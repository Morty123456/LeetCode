package NowCoder.meituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 9:10
 * @description:
 */
public class meituan_qz_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] aWant = new int[p];
        for (int i=0;i<p;i++){
            aWant[i] = sc.nextInt();
        }
        int[] bWant = new int[q];
        for (int i=0;i<q;i++){
            bWant[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int a : aWant)
            set.add(a);
        int aAndB = 0;
        for (int b: bWant){
            if (set.contains(b)){
                aAndB++;
            }
        }
        System.out.println((p-aAndB)+" "+(q-aAndB)+" "+aAndB);
    }
}

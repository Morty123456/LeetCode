package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class wangyi_daishipin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n+1];
        for(int i=1;i<=n;i++){
            v[i] = sc.nextInt();
        }
        long sum = 0;
        for (int vv : v)
            sum += vv;
//        System.out.print("sum:"+sum);
//        System.out.print(sum<=w);
        if (sum<=w)
            System.out.print((int)Math.pow(2, n));
        else
            System.out.print(getCount(n, w, v));
    }
    public static int getCount(int n, int w, int[] v){
        if (w<=0)
            return 0;
        if (n==1){
            if (v[n]<=w)
                return 2;
            else
                return 1;
        }
        return getCount(n-1, w, v) + getCount(n-1, w-v[n], v);
    }
}

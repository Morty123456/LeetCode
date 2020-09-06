package NowCoder.meituan;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 9:10
 * @description:
 */
public class meituan_qz_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }

    }
    public static int solution(int n,int[] a){
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            b[i] = a[i];
            //异或，相同为0，不同为1. j从1开始，每i个就是一轮循环，循环次数为偶数异或运算就会自动抵消
            int count = 0;
            for (int j = 1; j <= n; j++) {
                b[i] ^= (i%j);
            }
        }
        int res = 0;
        for (int num : b){
            res ^= num;
        }
        return res;
    }
    public static int solution2(int n, int[] a){
        int b = 0;
        for (int num : a){
            b ^= num;
        }
        //n为奇数
        if ((n&1)==1){
            for (int i=2;i<=n;i+=2){
                b ^= i;
            }
        }
        if ((n&1)==0){
            for (int i=1;i<=n;i+=2){
                 b ^= i;
            }
        }
        for (int i=1;i<=n;i++){
            for (int j=2;j<i;j++){
                b ^= (i%j);
            }
        }
        return b;
    }
}

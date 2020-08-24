package NowCoder.aiqiyi;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/23 14:31
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int i = 5;
        while (i<=n){
            int now = i;
            while(now%5==0){
                count++;
                now/=5;
            }
            i+=5;
        }
        System.out.println(count);
    }
}

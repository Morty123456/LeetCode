package NowCoder.shence;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/1 13:37
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;
        while (x>0){
            count += ((x&1)==1?1:0);
            x = x >> 1;
        }
        System.out.println(count==1);
    }
}

package NowCoder.baidu;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/3 19:37
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num==0)
                count0++;
            if (num==5)
                count1++;
        }
        if (count0==0 || count1<9)
            System.out.println(-1);
        else {
            int count = count1/9;
            String res = "";
            for (int i = 0; i < count; i++) {
                res += "555555555";
            }
            for (int i = 0; i < count0; i++) {
                res += 0;
            }
            System.out.println(res);
        }
    }
}

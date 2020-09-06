package NowCoder.meituan;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 9:10
 * @description:
 */
public class meituan_qz_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int up = 0, down = 0;
        for (char c : chars){
            if (c>='A' && c<='Z'){
                up++;
            }else {
                down++;
            }
        }
        System.out.println(Math.abs(up-down)/2);
    }
}

package NowCoder.M360;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/22 18:48
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        int count = 0;
        for (String s : strs){
            if (s.length()<=10){
                char[] chars = s.toCharArray();
                int i = 0;
                for (char ch : chars){
                    if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                        i++;
                    }else
                        break;
                }
                if (i==chars.length)
                    count++;
            }
        }
        System.out.println(count);
    }
}

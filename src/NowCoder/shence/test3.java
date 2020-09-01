package NowCoder.shence;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/1 13:37
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        sb.append((chars[0]+"").toLowerCase());
        for(int i=1;i<s.length();i++){
            if (chars[i]>='A' && chars[i]<='Z'){
                sb.append("_");
                String sNow = (chars[i]+"").toLowerCase();
                sb.append(sNow);
            }else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
}

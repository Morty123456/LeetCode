package NowCoder.M360;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/24 10:58
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int i=0;
        solution(ch, 0);
    }
    public static void solution(char[] chars, int i){
        if (i==chars.length)
            return;
        StringBuilder sb = new StringBuilder();
        String first = "";
        int n = i;
        while (i<chars.length && chars[i]!='n' || i==n){
            if(i==n)
                first += chars[i];
            else
                sb.append(chars[i]);
            i++;
        }
        first = first.toUpperCase();
        String last = sb.toString();
        System.out.println(first+last);
        solution(chars, i);
    }
}

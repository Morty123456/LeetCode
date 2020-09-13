package NowCoder.滴滴;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/13 19:00
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        solution(s, n);
    }
    public static void solution(String str, int n){
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        int start = 0, end = n-1;
        while (end<str.length()){
            for (int i=end;i>=start;i--)
                sb.append(chars[i]);
            start += n;
            end += n;
        }
        if (start<=str.length()-1){
            for (int i=str.length()-1; i>=start; i--){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
}

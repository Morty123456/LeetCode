package NowCoder.小米;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: wzh
 * @time: 2020/9/15 19:03
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
    }
    public static void solution(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char ch : chars){
            if (set.contains(ch))
                continue;
            else {
                sb.append(ch);
                set.add(ch);
            }
        }
        System.out.println(sb.toString());
    }
}

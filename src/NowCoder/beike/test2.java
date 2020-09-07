package NowCoder.beike;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: wzh
 * @time: 2020/9/7 14:49
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
    public static int solution(String str){
        int len = str.length();
        int count = str.length();
        for (int i=1; i<=len/2; i++){
            if (str.substring(0, i).equals(str.substring(i, 2 * i))){
                count = Math.min(count, len-i+1);
            }
        }
        return count;
    }
}

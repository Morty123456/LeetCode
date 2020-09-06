package NowCoder.laohu;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 16:41
 * @description:
 */

public class test2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        System.out.println(solution(chars));
    }
    public static boolean solution(char[] chars){
        int left = 0;
        int right = chars.length-1;
        while (left<right){
            while (!isByteOrNumber(chars[left])){
                left++;
            }
            while (!isByteOrNumber(chars[right])){
                right--;
            }
            if (!(chars[left]==chars[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isByteOrNumber(char ch){
        return (ch>='A' && ch<='Z') || (ch>='0' && ch<='9');
    }
}

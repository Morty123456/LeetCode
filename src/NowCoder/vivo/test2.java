package NowCoder.vivo;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/12 20:21
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        System.out.println(solution(chars));
    }
    public static String solution(char[] chars){
        int min = -1;
        boolean f = false;
        for (int i=0;i<chars.length;i++){
            int left = 0;
            int right = chars.length-1;
            while (left<right){
                if (left==i)
                    left++;
                if (right==i)
                    right--;
                if (chars[left]==chars[right]){
                    left++;
                    right--;
                }else
                    break;
            }
            if (left>=right){
                min = i;
                f = true;
                break;
            }
        }
        if (!f)
            return "false";
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<chars.length; i++){
            if (i!=min){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}

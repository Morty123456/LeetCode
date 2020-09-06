package NowCoder.laohu;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 16:41
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(primePalindrome(n));
    }
    public static int primePalindrome (int N) {
        while (true){
            if (isSuShu(N) && isHuiWen(N))
                return N;
            N++;
        }
    }
    public static boolean isSuShu(int num){
        for (int i=2;i<=num/2;i++){
            if ((num%i)==0)
                return false;
        }
        return true;
    }
    public static boolean isHuiWen(int num){
        String s = num+"";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (chars[left]!=chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}

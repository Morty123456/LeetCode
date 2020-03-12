package LeetCode;

import java.util.Map;

public class Easy_gcdOfStrings {
    public static void main(String[] args){
        String str1 = "abcabcabc";
        String str2 = "abcabc";
        System.out.println(gcdOfStrings(str1, str2));
    }
    public static String gcdOfStrings(String str1, String str2){
        if (!(str1+str2).equals(str2+str1))
            return "meiyou";
        int num = gcd(str1.length(), str2.length());
        return str1.substring(0, num);
    }
    public static int gcd(int a, int b){
        while (a!=0){
            int max = a>b ? a:b;
            int min = a<b ? a:b;
            a = max%min;
            b = min;
        }
        return b;
    }
}

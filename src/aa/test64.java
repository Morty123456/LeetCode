package aa;

import java.util.Scanner;

public class test64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(intToByte(n));
        System.out.println(ByteToInt(s));
    }
    public static String intToByte(int n){
        StringBuilder sb = new StringBuilder();
        while (n>0){
            sb.append(n%2);
            n /= 2;
        }
        char[] chars = sb.reverse().toString().toCharArray();
        int right = chars.length-1;
        StringBuilder res = new StringBuilder();
        while (right>=0){
            int high = 0;
            int low = 0;
            if (right<=6){
                int num = 0;
                for (int i=right; i>=0; i--){
                    num += (chars[i]-'0')*Math.pow(2, right-i);
                }
                if (num<16){
                    high = 0;
                    low = num;
                }else {
                    low = num%16;
                    high = num/16;
                }
            }else {
                low = (chars[right]-'0') + (chars[right-1]-'0')*2 + (chars[right-2]-'0')*4 + (chars[right-3]-'0')*8;
                high = (chars[right-4]-'0') + (chars[right-5]-'0')*2 + (chars[right-6]-'0')*4 + 8;
            }
            res.append("0X");
            res.append(intToChar(high));
            res.append(intToChar(low));
            right -= 7;
        }
        return res.toString();
    }
    public static String intToChar(int n){
        if (n<10)
            return n+"";
        else {
            char ch = (char)('a' + n-10);
            return ch+"";
        }
    }

    public static int ByteToInt(String s){
        int len = s.length();
        String res = "";
        for (int i=2; i<len; i+=4){
            char s1 = s.charAt(i);
            char s2= s.charAt(i+1);
            res = (charToInt(s2)) + res;
            if (i<len-4){
                res = (charToInt(s1).substring(1, 4)) + res;
            }else {
                res = (charToInt(s1)) + res;
            }
        }
        char[] chars = res.toCharArray();
        int num = 0;
        for (int i=chars.length-1; i>=0; i--){
            num += Math.pow(2, chars.length-1-i)*(chars[i]-'0');
        }
        return num;
    }
    public static String charToInt(char ch){
        int num = 0;
        if (ch>='0' && ch<='9')
            num = ch-'0';
        else
            num = 10+ch-'A';
        StringBuilder sb= new StringBuilder();
        while (num>0){
            sb.append(num%2);
            num /= 2;
        }
        for (int i=sb.length(); i<4; i++)
            sb.append("0");
        return sb.reverse().toString();
    }
}

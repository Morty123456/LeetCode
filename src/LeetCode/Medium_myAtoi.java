package LeetCode;

import java.util.Scanner;

public class Medium_myAtoi {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);

        String str = "   -0091a32";
        Medium_myAtoi mm = new Medium_myAtoi();
        System.out.println(mm.myAtoi(str));

    }
    public int myAtoi(String str){
        str = str.trim();
        int sum = 0;
        boolean minus = false;
        int i=0;
        int ch = str.charAt(0);
        if (ch=='-'){
            minus=true;
            i++;
        }
       if (ch=='+'){
            minus=false;
            i++;
        }
        if (ch!='-' && ch!='+' && (ch<'0' || ch>'9'))
            return 0;
        for (;i<str.length();i++){
            if (str.charAt(i)<'0' || str.charAt(i)>'9'){
                if (minus)
                    return -1*sum;
                else
                    return sum;
            }
            int num = str.charAt(i)-'0';
            if (sum > (Integer.MAX_VALUE/10)){
                if (minus)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            if (sum==(Integer.MAX_VALUE/10)){
                if (!minus && num<=7)
                    return sum*10+num;
                if (!minus && num>7)
                    return Integer.MAX_VALUE;
                if (minus && num<=8)
                    return (sum*10+num)*(-1);
                if (minus && num>8)
                    return Integer.MIN_VALUE;
            }
            sum = sum*10+num;
        }
        if (minus)
            return -1*sum;
        else
            return sum;
    }
}

package BroadView.SecondTime;

import java.util.Scanner;

public class ex_67_strToInt {
    public static void main(String[] args){
        String str = "2147483646";
        System.out.println(strToInt(str));
    }
    public static int strToInt(String str){
        str = str.trim();
        char[] ch = str.toCharArray();
        int length = ch.length;
        int i = 0;
        int sum = 0;
        if (ch.length==0 || (ch[i]>'9' && ch[i]!='-'))
            return 0;
        if (ch[i]=='-' || ch[i]=='+'){
            i++;
        }
        int max = Integer.MAX_VALUE/10;
        while (i<length){
            if (ch[i]<='9' && ch[i]>='0'){
                //越界判断很巧妙，如果sum==max时，只要>7，看似没有考虑 MIN，其实无论是 8 还是越界，返回的都是 MIN
                if (sum<max || (sum==max && ch[i]<='7') ){
                    sum = sum*10+ch[i]-'0';
                    i++;
                }else
                    return ch[0]=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else
                break;
        }
        if (ch[0]=='-')
            return sum*(-1);
        return sum;
    }
}

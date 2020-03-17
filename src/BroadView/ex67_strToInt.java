package BroadView;

import org.omg.PortableInterceptor.INACTIVE;

public class ex67_strToInt {
    public static void main(String[] args){
        String str = "2147483648";
        System.out.println(strToInt(str));
    }
    public static int strToInt(String str){
        str = str.trim();
        char[] ch = str.toCharArray();
        int count = 0;
        int isFushu = 1;
        for (int i=0;i<ch.length;i++){
            if (ch[i]>='0' && ch[i]<='9'){
                if (count>Integer.MAX_VALUE/10 || (count==Integer.MAX_VALUE/10 && (ch[i]-'0')>7))
                    return isFushu==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                count = count*10 + ch[i] - '0';
            }
            else if (i==0 && (ch[i]=='-' || ch[i]=='+')){
                isFushu = ch[i]=='-' ? -1 : 1;
            }
            else
                return count*isFushu;
        }
        return count*isFushu;
    }
}

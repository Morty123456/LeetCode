package NowCoder;

import java.util.Scanner;

public class meituan_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        int k = sc.nextInt();
        int count = 0;
        for (int i=0;i+2*k<length;i++){
            for (int j=2*k;i+j<length;j++){
                String str = s.substring(i,i+j+1);
                if (judgeStr(str, k))
                    count++;
            }
        }
        System.out.println(count);
    }
    public static boolean judgeStr(String str, int k){
        int length = str.length();
        int len;
        if (length%2==0)
            len=length/2-1;
        else
            len=length/2;
        for (int n=k;n<=len;n++){
            if (str.substring(0, n).equals(str.substring(length-n,length)))
                return true;
        }
        return false;
    }
}

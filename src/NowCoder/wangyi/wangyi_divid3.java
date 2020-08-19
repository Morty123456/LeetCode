package NowCoder.wangyi;

import java.util.Scanner;

public class wangyi_divid3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        count = (end-begin+1) - (end+2)/3 + (begin+1)/3;
        System.out.println(count);
    }
}

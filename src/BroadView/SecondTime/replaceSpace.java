package BroadView.SecondTime;

import java.util.Scanner;

public class replaceSpace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch==' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}

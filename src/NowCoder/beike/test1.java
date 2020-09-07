package NowCoder.beike;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/7 14:48
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++){
            String s = sc.nextLine();
            String[] chars = s.split(" ");
            int left = 0;
            int right = 0;
            if (compare(chars[0],chars[2]))
                left++;
            if (compare(chars[0], chars[3]))
                left++;
            if (compare(chars[1],chars[2]))
                right++;
            if (compare(chars[1], chars[3]))
                right++;
            if (left>right)
                System.out.println("left");
            else if (left<right)
                System.out.println("right");
            else
                System.out.println("same");
        }
    }
    public static boolean compare(String A, String B){
        char a = A.charAt(0);
        char b = B.charAt(0);
        if (a=='S' && b =='J')
            return true;
        else if (a=='J' && b=='B')
            return true;
        else if (a=='B' && b=='S')
            return true;
        else
            return false;
    }
}

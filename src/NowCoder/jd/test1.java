package NowCoder.jd;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/27 19:24
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lest = n;
        int ground = 3;
        int length = 1;
        while (n-ground>0){
            n -= ground;
            length++;
            ground *= 3;
        }
        System.out.println(solution(n, length));
    }
    public static String solution(int least, int length){
        String s = "";
        while (least>=1){
            double numInLine = Math.pow(3, length-1);
            double first = least/numInLine;
            if (first<=1){
                s += 2;
            }else if (first<=2){
                s += 3;
            }else if (first<=3){
                s += 5;
            }
            if(first%1==0){
                least -= ((int)first -1)*numInLine;
            }else
                least -= (int)first*numInLine;
            length--;
        }
        return s.substring(0, s.length()-1);
    }
}

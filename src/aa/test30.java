package aa;

import java.util.Scanner;

public class test30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int countE = solution(str.toCharArray(), 'E');
        int countF = solution(str.toCharArray(), 'F');
        System.out.println(Math.max(countE, countF));
    }
    public static int solution(char[] chars, char ch){
        int count = 0;
        int max = 0;
        for (int i=0; i<chars.length; i++){
            if (chars[i]==ch){
                count++;
            }else {
                count--;
            }
            max = Math.max(max, count);
            if (count<0){
                count = 0;
            }
        }
        return max;
    }
//    public static int solution(char[] chars){
//        int len = chars.length;
//        // E-F 的个数
//        int[][] dp = new int[len][len];
//        for (int i=0; i<len; i++){
//            if (chars[i]=='E')
//                dp[i][i] = 1;
//            else
//                dp[i][i] = -1;
//        }
//        for (int i=1; i<len; i++){
//            for (int j=0; j<i; j++){
//                if ()
//            }
//        }
//    }
}

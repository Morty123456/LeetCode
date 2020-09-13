package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/13 9:14
 * @description:
 */
public class Medium_longestPalindrome2 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(solution(s));
    }
    public static String solution(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i=0;i<len;i++){
            dp[i][i] = true;
        }
        int max = 0;
        int begin = 0;
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (s.charAt(i)==s.charAt(j)){
                    if (i-j<=2)
                        dp[j][i] = true;
                    else
                        dp[j][i] = dp[j+1][i-1];
                    if (i-j+1>max && dp[j][i]){
                        max = i-j+1;
                        begin = j;
                    }
                }
                else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substring(begin, begin+max);
    }
}

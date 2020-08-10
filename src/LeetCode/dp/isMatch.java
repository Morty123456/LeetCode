package LeetCode.dp;

/**
 * @author: wzh
 * @time: 2020/8/10 14:10
 * @description:
 */
public class isMatch {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "a*b";
        System.out.println(isMatch(s, p));
    }
    public static boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <=p.length() ; i++) {
            if (p.charAt(i-1)!='*')
                break;
            dp[0][i] = true;
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[s.length()][p.length()];
    }
}

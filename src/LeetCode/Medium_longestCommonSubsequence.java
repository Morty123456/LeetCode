package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/5 23:04
 * @description:
 */
public class Medium_longestCommonSubsequence {
    public static void main(String[] args) {
        String l1 = "abcde";
        String l2 = "ace";
        System.out.println(longestCommonSubsequence(l1, l2));
    }
    public static int longestCommonSubsequence(String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}

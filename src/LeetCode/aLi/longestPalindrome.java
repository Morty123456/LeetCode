package LeetCode.aLi;

/**
 * @author: wzh
 * @time: 2020/8/7 15:09
 * @description:
 */
public class longestPalindrome {
    public static void main(String[] args){
        String s = "ac";
        System.out.println(longestBp(s));
    }
    public static String longestBaoLi(String s){
        int len = s.length();
        if (len<2)
            return s;
        int maxLen = 1;
        int begin = 0;
        char[] chaArr = s.toCharArray();
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if (j-i+1>maxLen && judge(chaArr, i, j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
    public static boolean judge(char[] chArr, int begin, int end){
        while (begin<end){
            if (chArr[begin]!=chArr[end])
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public static String longestBp(String s){
        int len = s.length();
        if (len<2)
            return s;
        boolean[][] dp = new boolean[len][len];
        for (int i=0;i<len;i++)
            dp[i][i] = true;
        char[] chArr = s.toCharArray();
        int max = 1, begin = 0;
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if (chArr[i]!=chArr[j])
                    dp[i][j]=false;
                else {
                    if (j-i<3)
                        dp[i][j]=true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j-i+1>max){
                    max = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+max);
    }
}

package BroadView.SecondTime;

public class isMatch {
    public static void main(String[] args){
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
    }
    public static boolean isMatch(String s, String p){
        if (s==null || p==null)
            return false;
        int rows = s.length();
        int rowp = p.length();
        boolean[][] dp = new boolean[rows+1][rowp+1];
        dp[0][0] = true;
        //计算s为null时，p是否可以变为null
        for (int j=1;j<=rowp;j++){
            if (p.charAt(j-1)=='*' && dp[0][j-2])
                dp[0][j]=true;
        }
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=rowp;j++){
                char nows = s.charAt(i-1);
                char nowp = p.charAt(j-1);
                //如果现在位置的两个字符相等，那么此位置就取决于上一个位置
                if (nows==nowp || nowp=='.')
                    dp[i][j] = dp[i-1][j-1];
                //如果p的位置是*
                else if (nowp=='*'){
                    if (j>=2){
                        char nowpLast = p.charAt(j-2);
                        if (nowpLast==nows || nowpLast=='.'){
                            //如果*代表前面字符出现一次，或者代表前面的字符出现很多次
                            dp[i][j] = dp[i][j-1] || dp[i-1][j];
                        }
                        //p中去掉*和其前一个字符，这里后面的或运算符是因为dp[i][j]在上面可能已经计算过一次了
                        dp[i][j] = dp[i][j] || dp[i][j-2];
                    }
                }
                else
                    dp[i][j] = false;
            }
        }
        return dp[rows][rowp];
    }
}

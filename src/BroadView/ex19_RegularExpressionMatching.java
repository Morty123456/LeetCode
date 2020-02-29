package BroadView;

import java.util.Scanner;

public class ex19_RegularExpressionMatching {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(daan_isMatch(s, p));
    }
    public static boolean daan_isMatch(String s, String p){
        /*
       s和p可能为空。空的长度就是0，但是这些情况都已经判断过了，只需要判断是否为null即可
       if(p.length()==0&&s.length()==0)
            return true;
            */
        if(s==null||p==null)
            return false;
        int rows = s.length();
        int columns = p.length();
        boolean[][]dp = new boolean[rows+1][columns+1];
        //s和p两个都为空，肯定是可以匹配的，同时这里取true的原因是
        //当s=a，p=a，那么dp[1][1] = dp[0][0]。因此dp[0][0]必须为true。
        dp[0][0] = true;
        for(int j=1;j<=columns;j++)
        {
            //p[j-1]为*可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
            //因此dp[j-2]也要为true，才可以说明前j个为true
            if(p.charAt(j-1)=='*'&&dp[0][j-2])
                dp[0][j] = true;
        }

        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=columns;j++)
            {
                char nows = s.charAt(i-1);
                char nowp = p.charAt(j-1);
                if(nows==nowp)
                {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(nowp=='.')
                        dp[i][j] = dp[i-1][j-1];
                    else if(nowp=='*')
                    {
                        //p需要能前移1个。（当前p指向的是j-1，前移1位就是j-2，因此为j>=2）
                        if(j>=2){
                            char nowpLast = p.charAt(j-2);
                            //只有p[j-2]==s[i-1]或p[j-2]==‘.’才可以让*取1个或者多个字符：
                            if(nowpLast==nows||nowpLast=='.')
                                dp[i][j] = dp[i-1][j]||dp[i][j-1];
                            //不论p[j-2]是否等于s[i-1]都可以删除掉j-1和j-2处字符：
                            dp[i][j] = dp[i][j]||dp[i][j-2];
                        }
                    }
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[rows][columns];
    }
    public static boolean isMatch(String s, String p){
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] matched = new boolean[sLength+1][pLength+1];
        matched[0][0] = true;
        for (int i=0;i<p.length();i++)
            if (p.charAt(i)=='*' && matched[0][i-1])
                matched[0][i+1]=true;
        //状态转移
        for (int i=0;i<sLength;i++){
            for (int j=0;j<pLength;j++){
                if(p.charAt(j)=='.' || p.charAt(j)==s.charAt(i)){
                    matched[i+1][j+1]=matched[i][j];
                }
                if (p.charAt(j)=='*'){
                    if (s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.'){
                        matched[i+1][j+1] = matched[i+1][j-1];
                    }
                    else{
                        matched[i+1][j+1] = matched[i][j+1] || matched[i+1][j] || matched[i+1][j-1];
                    }
                }
            }
        }
        return matched[sLength-1][pLength-1];
    }
}

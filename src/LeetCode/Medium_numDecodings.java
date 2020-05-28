package LeetCode;

public class Medium_numDecodings {
    public static void main(String[] args){
        System.out.println(numDecodings2("200"));
    }
    public static int numDecodings(String s){
        char[] ch = s.toCharArray();
        if (ch[0]=='0')
            return 0;
        int pre = 1, cur = 1;
        for (int i=1;i<ch.length;i++){
            int tmp = cur;
            if (ch[i]=='0'){
                if (ch[i-1]=='1' || ch[i-1]=='2')
                    cur = pre;
                else
                    return 0;
            }
            else {
                if (ch[i-1]=='1' || (ch[i-1]=='2'&&ch[i]>='1'&&ch[i]<='6')){
                    cur += pre;
                }
            }
            pre = tmp;
        }
        return cur;
    }
    public static int numDecodings2(String s){
        char[] ch = s.toCharArray();
        int[] dp = new int[s.length()];
        if (ch[0]=='0')
            return 0;
        if (ch.length==1)
            return 1;
        dp[0] = 1;
        if (ch[0]=='1' && ch[1]!='0')
            dp[1]=2;
        else if (ch[0]=='2' && ch[1]>='1' && ch[1]<='6')
            dp[1]=2;
        else
            dp[1]=1;
        for (int i=2;i<ch.length;i++){
            if (ch[i]=='0') {
                if (dp[i-1]=='1' || dp[i-1]=='2')
                    dp[i] = dp[i - 2];
                else
                    return 0;
            }
            else if (ch[i-1]=='1')
                dp[i] = dp[i-1]+dp[i-2];
            else if (ch[i-1]=='2' && ch[i]>='1' && ch[i]<='6')
                dp[i] = dp[i-1]+dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[ch.length-1];
    }
}

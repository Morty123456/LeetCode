package BroadView;

public class ex46_translateNum {
    public static void main(String[] args){
        int num = 506;
        System.out.println(translateNum(num));
    }
    public static int translateNum(int num){
        String str = num+"";
        int[] dp = new int[str.length()+1];
        dp[0] = dp[1] = 1;
        for (int i=2;i<=str.length();i++) {
            String subStr = str.charAt(i-2)+""+str.charAt(i-1);
            if (str.charAt(i-2)=='0' || Integer.valueOf(subStr) - 25 > 0)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i-2];
        }
        return dp[str.length()];
    }
}

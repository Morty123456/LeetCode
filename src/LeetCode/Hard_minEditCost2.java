package LeetCode;

public class Hard_minEditCost2 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "adc";
        System.out.println(minEditCost(str1, str2, 5,3,100));
    }
    public static int minEditCost(String str1, String str2, int ic, int dc, int rc){
        int row = str1.length();
        int col = str2.length();
        int[][] dp = new int[row+1][col+1];
        for (int i=0; i<=row; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=col; j++){
            dp[0][j] = j;
        }
        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1]+rc, Math.min(dp[i-1][j]+dc, dp[i][j-1]+ic));
                }
            }
        }
        return dp[row][col];
    }
}

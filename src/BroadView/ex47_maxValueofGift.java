package BroadView;

public class ex47_maxValueofGift {
    public static void main(String[] args){
        int[][] grid = {
//                {1,3,2},
//                {1,5,1},
//                {4,2,1}
                {1,2,5},
                {3,2,1}
        };
        System.out.println(maxValue(grid));
    }
    public static int maxValue(int[][] dp){
        int row = dp.length;
        int col = dp[0].length;
//        int[][] dp = new int[row][col];
//        dp[0][0] = grid[0][0];
        for (int i=1;i<col;i++)
            dp[0][i] += dp[0][i-1];
        for (int i=1;i<row;i++)
            dp[i][0] += dp[i-1][0];
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
}

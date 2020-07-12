package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/12 8:22
 * @description:
 */
public class Hard_calculateMinimumHP {
    public static void main(String[] args){
        int[][] dungeon = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
    public static int calculateMinimumHP(int[][] dungeon){
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        for (int i=row-1;i>=0;i--){
            for (int j=col-1;j>=0;j--){
                if (i==row-1 && j==col-1)
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                else if (i==row-1){
                    dp[i][j] = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                }
                else if (j==col-1){
                    dp[i][j] = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                }
                else
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

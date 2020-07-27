package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/26 8:37
 * @description:
 */
public class Hard_longestIncreasingPath {
    public static void main(String[] args){
        int[][] nums = {{9,9,4},{6,6,8},{2,1,1}};
        Hard_longestIncreasingPath hl = new Hard_longestIncreasingPath();
        int h = hl.longestIncreasingPath(nums);
        int b = 0;
        System.out.println(h);
    }
    public int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int row, col;
    public int longestIncreasingPath(int[][] matrix){
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        row = matrix.length;
        col = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                ans = Math.max(ans, dfs(matrix, i, j ,memo));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int r, int c, int[][] memo){
        if (memo[r][c]!=0)
            return memo[r][c];
        ++memo[r][c];
        for (int[] dir : dirs){
            int newR = r+dir[0], newC = c+dir[1];
            if (newR>=0 && newR<row && newC>=0 && newC<col && matrix[newR][newC]>matrix[r][c]){
                memo[r][c] = Math.max(memo[r][c], dfs(matrix, newR, newC, memo)+1);
            }
        }
        return memo[r][c];
    }
}

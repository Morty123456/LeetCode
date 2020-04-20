package LeetCode;

import java.util.LinkedList;

public class Medium_numIslands {
    public static void main(String[] args){
        char[][] grid = {
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'1','0','1','0','0'},
                {'0','0','0','1','0'}
        };
        char[][] grid2 = {
                {'1','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid){
        int row = grid.length;
        if (row==0)
            return 0;
        int col = grid[0].length;
//        boolean[][] visited = new boolean[row][col];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]=='1'){
                    list.add(i);
                    list.add(j);
                    while (!list.isEmpty()){
                        int x = list.removeFirst();
                        int y = list.removeFirst();
                        for (int[] d : dir){
                            int xNow = x+d[0];
                            int yNow = y+d[1];
                            if (xNow>=0 && xNow<row && yNow>=0 && yNow<col && grid[xNow][yNow]=='1'){
                                list.add(xNow);
                                list.add(yNow);
                                grid[xNow][yNow]='0';
//                                visited[xNow][yNow]=true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}

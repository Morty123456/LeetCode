package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Medium_maxAreaOfIsland {
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAresOfIsland(grid));
    }
    public static int maxAresOfIsland(int[][] grid){
        int row = grid.length;
        if (row==0)
            return 0;
        int col = grid[0].length;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxArea = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                    grid[i][j]=0;
                    int area = 1;
                    queue.add(i);
                    queue.add(j);
                    while (!queue.isEmpty()){
                        int x = queue.poll(), y = queue.poll();
                        for (int[] dir : direction){
                            if (x+dir[0]>=0 && x+dir[0]<row && y+dir[1]>=0 && y+dir[1]<col && grid[x+dir[0]][y+dir[1]]==1){
                                area++;
                                queue.add(x+dir[0]);
                                queue.add(y+dir[1]);
                                grid[x+dir[0]][y+dir[1]]=0;
                            }
                        }
                    }
                    maxArea = maxArea>area ? maxArea:area;
                }
            }
        }
        return maxArea;
    }
}

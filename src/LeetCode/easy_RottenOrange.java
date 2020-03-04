package LeetCode;

import java.util.LinkedList;

public class easy_RottenOrange {
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid1 = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] gride2 = {{0}};
        System.out.print(orangeRotting(gride2));
    }
    public static int orangeRotting(int[][] grid){
        int count = 0, pre = 0, next = 0, num = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int row = grid.length, col = grid[0].length;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]!=0)
                    num++;
                if (grid[i][j]==2){
                    list.add(i);
                    list.add(j);
                    pre++;
                }
            }
        }
        if(num==0)
            return 0;
        while (!list.isEmpty()){
            while (pre-->0){
                num--;
                int x = list.remove();
                int y = list.remove();
                for (int[] dir : direction){
                    if (judge(grid, x+dir[0], y+dir[1])){
                        grid[x+dir[0]][y+dir[1]]=2;
                        list.add(x+dir[0]);
                        list.add(y+dir[1]);
                        next++;
                    }
                }
            }
            pre = next;
            next = 0;
            if (num==0)
                return count;
            count++;
        }
        return -1;
    }
    public static boolean judge(int[][] grid, int x, int y){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1)
            return true;
        return false;
    }
}

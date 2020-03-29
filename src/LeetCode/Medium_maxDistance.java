package LeetCode;

import java.util.LinkedList;

public class Medium_maxDistance {
    public static void main(String[] args){
        int[][] grid = {{1,1,1},
                {1,1,1},
                {1,1,1}};
        System.out.println(maxDistance(grid));
    }
    public static int maxDistance(int[][] grid){
        int maxDis = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int row = grid.length;
        int col = row;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        if (list.size()==0 || list.size()==row*row*2)
            return -1;
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        while (!list.isEmpty()){
            int x = list.poll();
            int y = list.poll();
            for (int[] d : dir){
                if (x+d[0]>=0 && x+d[0]<row && y+d[1]>=0 && y+d[1]<col){
                    if (grid[x+d[0]][y+d[1]]==0){
                        grid[x+d[0]][y+d[1]] = grid[x][y]+1;
                        list.add(x+d[0]);
                        list.add(y+d[1]);
                        maxDis =  maxDis > grid[x+d[0]][y+d[1]]-1 ? maxDis : grid[x+d[0]][y+d[1]]-1;
                    }
                }
            }
        }
        return maxDis;
    }
}

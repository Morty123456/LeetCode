package aa;

import java.util.Stack;

public class test54 {
    public static void main(String[] args) {
        int[][] land = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int[][] land2 = {{1,1},{1,1}};
        System.out.println(islandPerimeter(land2));
    }
    public static int islandPerimeter(int[][] grid) {
        Stack<int[]> stack = new Stack<>();
        int[] begin = new int[2];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    begin[0] = i;
                    begin[1] = j;
                    break;
                }
            }
        }
        int max = 0;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        stack.push(begin);
        grid[begin[0]][begin[1]] = -1;
        while (!stack.isEmpty()){
            int[] res = stack.pop();
            int x = res[0];
            int y = res[1];
            int line = 4;
            for (int[] dir : direction){
                int xNext = x+dir[0];
                int yNext = y+dir[1];
                if (xNext>=0 && xNext<grid.length && yNext>=0 && yNext<grid[0].length && grid[xNext][yNext]!=0){
                    if (grid[xNext][yNext]==1){
                        int[] add = {xNext, yNext};
                        grid[xNext][yNext] = -1;
                        stack.add(add);
                    }
                    line--;
                }
            }
            max += line;
        }
        return max;
    }
}

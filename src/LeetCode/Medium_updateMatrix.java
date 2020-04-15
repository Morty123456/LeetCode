package LeetCode;

import java.util.LinkedList;

public class Medium_updateMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}};
        int[][] upMatrix = updateMatrix(matrix);
        for (int[] a: upMatrix){
            for (int aa: a)
                System.out.print(aa+" ");
            System.out.println();
        }
    }
    public static int[][] updateMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (matrix[i][j]==0){
                    list.add(i);
                    list.add(j);
                    visited[i][j]=true;
                }
            }
        }
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
        while (!list.isEmpty()){
            int x = list.pollFirst();
            int y = list.pollFirst();
            for (int[] di : dir){
                int xNow = x+di[0];
                int yNow = y+di[1];
                if(xNow>=0 && xNow<row && yNow>=0 && yNow<col && !visited[xNow][yNow]){
                    matrix[xNow][yNow] = matrix[x][y]+1;
                    visited[xNow][yNow] = true;
                    list.add(xNow);
                    list.add(yNow);
                }
            }
        }
        return matrix;
    }
}

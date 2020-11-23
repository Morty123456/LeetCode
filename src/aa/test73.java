package aa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test73 {
    public static void main(String[] args) {
        int[][] res = allCellsDistOrder(2,2,0,1);
        for (int[] num : res)
            System.out.println(num[0]+" "+num[1]);
    }
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0){
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        LinkedList<int[]> list = new LinkedList<>();
        int[] yd= {r0, c0};
        queue.add(yd);
        boolean[][] visited = new boolean[R][C];
        visited[r0][c0] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            list.add(now);
            for (int[] dir : direction){
                int nextX = now[0]+dir[0];
                int nextY = now[1]+dir[1];
                if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !visited[nextX][nextY]){
                    int[] next= {nextX, nextY};
                    visited[nextX][nextY] = true;
                    queue.add(next);
                }
            }
        }
        return list.toArray(new int[R*C][2]);
    }
}

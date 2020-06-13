package BroadView.SecondTime;

import java.util.LinkedList;

public class movingCount {
    public static void main(String[] args){
        System.out.println(movingCount2(3,2,1));
    }
    public static int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);list.add(0);
        visited[0][0] = true;
        int count = 1;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!list.isEmpty()){
            int x = list.removeFirst();
            int y = list.removeFirst();
            for (int[] dir : direction){
                int xNow = x+dir[0];
                int yNow = y+dir[1];
                if (xNow>=0 && xNow<m && yNow>=0 && yNow<n && !visited[xNow][yNow] && getNum(xNow)+getNum(yNow)<=k){
                    count++;
                    list.add(xNow);
                    list.add(yNow);
                    visited[xNow][yNow]=true;
                }
            }
        }
        return count;
    }
    public static int movingCount2(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        return dfs(m,n,0,0, k, visited);
    }
    public static int dfs(int m, int n, int xNow, int yNow, int k, boolean[][] visited){
        int count = 0;
        if(xNow>=0 && xNow<m && yNow>=0 && yNow<n && !visited[xNow][yNow] && getNum(xNow)+getNum(yNow)<=k){
            visited[xNow][yNow]=true;
            count = 1+dfs(m,n,xNow+1,yNow,k,visited)+dfs(m,n,xNow-1,yNow,k,visited)+dfs(m,n,xNow,yNow+1,k,visited)+dfs(m,n,xNow,yNow-1,k,visited);
        }
        return count;
    }
    public static int getNum(int n){
        int sum = 0;
        while (n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}

package BroadView;

import java.util.LinkedList;
import java.util.Queue;

public class ex13_rangeMontionOfRobot {
    public static void main(String[] args){
        int m=16, n=8, k=4;
        System.out.println(movingCount2(m,n,k));
    }
    public static int movingCount2(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        return diguiFind(m,n,0,0,k,visited);
    }
    public static int diguiFind(int row, int col, int nowRow, int nowCol, int k, boolean[][] visited){
        int count=0;
        if (nowRow>=0 && nowRow<row && nowCol>=0 && nowCol<col && toSum(nowRow)+toSum(nowCol)<=k && visited[nowRow][nowCol]==false){
            visited[nowRow][nowCol]=true;
            count=1+diguiFind(row,col,nowRow-1,nowCol,k,visited)
                   +diguiFind(row,col,nowRow+1,nowCol,k,visited)
                   +diguiFind(row,col,nowRow,nowCol+1,k,visited)
                   +diguiFind(row,col,nowRow,nowCol-1,k,visited);
        }
        return count;
    }
    //利用队列
    public static int movingCount(int m, int n, int k){
        if (k<0)
            return 0;
        int count=1;
        boolean[][] visited=new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        visited[0][0]=true;
        int[][] order={{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int row = queue.poll();
            int col = queue.poll();
            for (int[] ord : order){
                int nowRow=row+ord[0], nowCol=col+ord[1];
                if(nowRow>=0 && nowRow<m && nowCol>=0 && nowCol<n && toSum(nowRow)+toSum(nowCol)<=k && visited[nowRow][nowCol]==false){
                    visited[nowRow][nowCol]=true;
                    queue.offer(nowRow);
                    queue.offer(nowCol);
                    count++;
                }
            }
        }
        return count;
    }
    public static int toSum(int num){
        int sum=0;
        while (num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}

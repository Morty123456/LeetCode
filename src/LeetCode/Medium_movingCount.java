package LeetCode;

import java.util.LinkedList;

public class Medium_movingCount {
    public static void main(String[] args){
        System.out.println(movingCount2(3,1,0));
    }
    //递归
    public static int movingCount2(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        return diguiFind(m,n,k,0,0,visited);
    }
    public static int diguiFind(int m, int n, int k, int xNow, int yNow, boolean[][] visited){
        int count = 0;
        if (xNow>=0 && xNow<m && yNow>=0 && yNow<n && !visited[xNow][yNow] && getSun(xNow)+getSun(yNow)<=k){
            visited[xNow][yNow]=true;
            count = 1+diguiFind(m,n,k,xNow+1,yNow, visited)
                    + diguiFind(m,n,k,xNow-1, yNow, visited)
                    + diguiFind(m,n,k,xNow, yNow+1, visited)
                    + diguiFind(m,n,k,xNow, yNow-1, visited);
        }
        return count;
    }
    public static int getSun(int num){
        int sum = 0;
        while (num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    //速度太慢
    public static int movingCount(int m, int n, int k){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(0);
        boolean[][] judege = new boolean[m][n];
        judege[0][0] = true;
        int count = 1;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!list.isEmpty()){
            int x = list.removeFirst();
            int y = list.removeFirst();
            for (int[] dir: direction){
                int xNow = x+dir[0];
                int yNow = y+dir[1];
                if (xNow>=0 && xNow<m &&yNow>=0 && yNow<n && canGet(xNow, yNow, k) && !judege[xNow][yNow]){
                    count++;
                    list.add(xNow);
                    list.add(yNow);
                    judege[xNow][yNow] = true;
                }
            }
        }
        return count;
    }
    public static boolean canGet(int i, int j, int k){
        int sum = 0;
        while (i!=0){
            sum+=i%10;
            i=i/10;
        }
        while (j!=0){
            sum+=j%10;
            j=j/10;
        }
        return sum<=k;
    }
}

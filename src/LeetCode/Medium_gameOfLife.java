package LeetCode;

import java.util.LinkedList;

public class Medium_gameOfLife {
    public static void main(String[] args){
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        Medium_gameOfLife mg = new Medium_gameOfLife();
        mg.gameOfLife(board);
        for (int[] bo : board){
            for (int b : bo)
                System.out.print(b+" ");
            System.out.println();
        }
    }
    public void gameOfLife(int[][] board){
        if (board.length==0)
            return;
        int row = board.length;
        int col = board[0].length;
//        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int count = getAroundAlive(board, i, j, row, col);
                if (board[i][j]==0 && count==3){
                    board[i][j]=2;
//                    list.add(i);list.add(j);
                }
                if (board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=-1;
//                    list.add(i);list.add(j);
                }
            }
        }

        for (int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]==-1)
                    board[i][j]=0;
                if (board[i][j]==2)
                    board[i][j]=1;
            }
        }
//        while (!list.isEmpty()){
//            int x = list.removeFirst();
//            int y = list.removeFirst();
//            board[x][y] ^= 1;
//        }
    }
    public int getAroundAlive(int[][] board, int x, int y, int row, int col){
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for (int[] dir:direction){
            int xNow = x+dir[0];
            int yNow = y+dir[1];
            if (xNow>=0 && xNow<row && yNow>=0 && yNow<col && (board[xNow][yNow]==1 || board[xNow][yNow]==-1))
                count++;
        }
        return count;
    }
}

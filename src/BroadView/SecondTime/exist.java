package BroadView.SecondTime;

import java.util.LinkedList;
import java.util.Scanner;

public class exist {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[row][col];
        for (int i=0;i<row;i++){
            String s = sc.nextLine();
            String[] ch = s.split(" ");
            for (int j=0;j<col;j++){
                board[i][j] = ch[j].toCharArray()[0];
            }
        }
        System.out.println(exist(board, "abcced"));
    }
    public static boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board, w, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, char[] word, int i, int j, int k){
        if (i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=word[k])
            return false;
        if (k==word.length-1)
            return true;
        char tmp = board[i][j];
        board[i][j]='/';
        boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1) || dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = tmp;
        return res;
    }
}

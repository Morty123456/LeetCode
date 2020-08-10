package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/8/11 7:02
 * @description:
 */
public class Medium_solve {
    public static void main(String[] args) {
        char[][] c = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','O','X'},
                {'X','O','X','X'}};
        solve(c);
        for (char[] ch : c){
            for (char c1 : ch){
                System.out.print(c1+" ");
            }
            System.out.println();
        }
    }
    static boolean[][] visited;
    static List<Stack<Integer>> list;
    static int row;
    static int col;
    static char[][] cha;
    public static void solve(char[][] board){
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        list = new LinkedList<>();
        cha = board;
        int[] a1 = {0, row-1};
        for (int i : a1){
            for (int j=0;j<col;j++){
                if (cha[i][j]=='O'){
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i);
                    stack.push(j);
                    list.add(stack);
                    visited[i][j] = true;
                }
            }
        }
        int[] a2 = {0, col-1};
        for (int i=0;i<row;i++) {
            {
                for (int j : a2) {
                    if (cha[i][j] == 'O') {
                        Stack<Integer> stack = new Stack<>();
                        stack.push(i);
                        stack.push(j);
                        list.add(stack);
                        visited[i][j] = true;
                    }
                }
            }
        }
        for (Stack<Integer> stack : list){
            find(stack);
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    public static void find(Stack<Integer> stack){
        int[][] local = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!stack.isEmpty()){
            int y = stack.pop();
            int x = stack.pop();
            for (int[] lo : local){
                int xNow = x + lo[0];
                int yNow = y + lo[1];
                if (xNow>=0 && xNow<row && yNow>=0 && yNow<col &&
                        !visited[xNow][yNow] && cha[xNow][yNow]=='O'){
                    visited[xNow][yNow] = true;
                    stack.push(xNow);
                    stack.push(yNow);
                }
            }
        }

    }
}

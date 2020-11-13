package aa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    public static List<List<String>> solution(int n){
        List<List<String>> lists = new LinkedList<>();
        char[][] chars = new char[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(chars[i], '.');
        }
        dfs(chars, lists, 0);
        int i = 0;
        return lists;
    }
    public static void dfs(char[][] chars, List<List<String>> list, int row){
        if (row==chars.length){
            list.add(toString(chars));
        }
        for (int col=0; col<chars.length; col++){
            if (judge(chars, row, col)){
                chars[row][col]='Q';
                dfs(chars, list, row+1);
                chars[row][col]='.';
            }
        }
    }
    public static List<String> toString(char[][] chars){
        List<String> list = new LinkedList<>();
        for (char[] ch : chars){
            list.add(new String(ch));
        }
        return list;
    }
    public static boolean judge(char[][] chars, int x, int y){
        for (int i=0; i<x; i++){
            for (int j=0; j<chars.length; j++){
                if (chars[i][j]=='Q' && (y==j || (Math.abs(i-x)==Math.abs(j-y)))){
                    return false;
                }
            }
        }
        return true;
    }
}

package aa;

import java.util.Arrays;
import java.util.Scanner;

public class test45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    static int count = 0;
    public static int solution(int n){
        char[][] chars = new char[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(chars[i], '.');
        }
        dfs(chars, 0);
        return count;
    }
    public static void dfs(char[][] chars, int rows){
        if (rows==chars.length){
            count++;
            return;
        }
        for (int col=0; col<chars.length; col++){
            if (judge(chars, rows, col)){
                chars[rows][col]='Q';
                dfs(chars, rows+1);
                chars[rows][col]='.';
            }
        }
    }
    public static boolean judge(char[][] chars, int x, int y){
        for (int i=0; i<x; i++){
            for (int j=0; j<chars.length; j++){
                if (chars[i][j]=='Q' && (y==j||(Math.abs(x-i)==Math.abs(y-j)))){
                    return false;
                }
            }
        }
        return true;
    }
}

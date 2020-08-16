package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/16 17:26
 * @description:
 */
public class NQueen {
    public static void main(String[] args) {
        List<List<String>> lists = backTrace(4);
        for (List<String> list : lists ){
            for (String s : list){
                System.out.println(s);
            }
            System.out.println("------------------------------");
        }
    }
    public static List<List<String>> backTrace(int n){
        char[][] chars = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        List<List<String>> lists = new LinkedList<>();
        dfs(chars, lists, 0, n);
        return lists;
    }
    public static void dfs(char[][] chars, List<List<String>> lists, int row, int n){
        if (row==n){
            lists.add(toString(chars));
            return;
        }
        for (int col = 0; col < chars.length; col++) {
            if (isValid(chars, row, col)){
                chars[row][col]='Q';
                dfs(chars, lists, row+1, n);
                chars[row][col]='.';
            }
        }
    }
    public static List<String> toString(char[][] chs){
        List<String> list = new LinkedList<>();
        for (int i = 0; i < chs.length; i++) {
            list.add(new String(chs[i]));
        }
        return list;
    }
    public static boolean isValid(char[][] chars, int x, int y){
        for (int i=0;i<x;i++){
            for (int j=0;j<chars.length;j++){
                if (chars[i][j]=='Q' && (j==y || Math.abs(x-i)==Math.abs(y-j)))
                    return false;
            }
        }
        return true;
    }
}

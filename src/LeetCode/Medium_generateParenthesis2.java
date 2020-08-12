package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/12 8:30
 * @description:
 */
public class Medium_generateParenthesis2 {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = solution(3);
        for (String s : list)
            System.out.println(s);
    }
    public static List<String> solution(int n){
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(list, n, n, sb);
        return list;
    }
    public static void dfs(List<String> list, int left, int right, StringBuilder sb){
        if (left==0 && right==0)
            list.add(sb.toString());
        if (left>right)
            return;
        if (left>0){
            sb.append("(");
            dfs(list, left-1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right>0){
            sb.append(")");
            dfs(list, left, right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

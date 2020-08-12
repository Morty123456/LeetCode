package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/12 8:39
 * @description:
 */
public class Medium_letterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        List<String> list = solution(digits);
        for (String s : list)
            System.out.println(s);
    }
    public static List<String> solution(String digits){
        String[] strs = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        dfs(list, 0, digits, sb, strs);
        return list;
    }
    public static void dfs(List<String> list, int start, String digits, StringBuilder sb, String[] strs){
        if (start==digits.length()){
            list.add(sb.toString());
            return;
        }
        int num = digits.charAt(start)-'0';
        for (char ch : strs[num].toCharArray()){
            sb.append(ch);
            dfs(list, start+1, digits, sb, strs);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

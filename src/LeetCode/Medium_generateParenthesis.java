package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Medium_generateParenthesis {
    public static void main(String[] args){
        List<String> list = generateParenthesis(3);
        for (String str : list)
            System.out.println(str);
    }
    public static List<String> generateParenthesis(int n){
        if (n==0)
            return new ArrayList<>();
        List<List<String>> dp = new ArrayList<>(n);
        List<String> list0 = new LinkedList<>();
        list0.add("");
        dp.add(list0);
        for (int i=1;i<=n;i++){
            List<String> cur = new ArrayList<>();
            for (int j=0;j<i;j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-1-j);
                for (String s1 : str1){
                    for (String s2 : str2){
                        cur.add("("+s1+")"+s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}

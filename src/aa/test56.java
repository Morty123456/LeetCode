package aa;

import java.util.*;

public class test56 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> w = new LinkedList<>();
        w.add("cat");
        w.add("cats");
        w.add("and");
        w.add("sand");
        w.add("dog");
        List<String> list = wordBreak(s, w);
        for (String one : list)
            System.out.println(one);
    }
    public static List<String> wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int right=1; right<=len; right++){
            for (int left=right-1; left>=0; left--){
                if (wordSet.contains(s.substring(left, right)) && dp[left]){
                    dp[right] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[len]){
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, dp, path, res);
            return res;
        }
        return res;
    }
    public static void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res){
        if (len==0){
            res.add(String.join(" ", path));
            return;
        }
        for (int i=len-1; i>=0; i--){
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]){
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}

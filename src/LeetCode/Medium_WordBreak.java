package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 字符串是否可以由字符数组组成
 * @author: wzh
 * @create: 2019-12-22 13:03
 **/
public class Medium_WordBreak {
    public static void main(String[] args){
        String s = "applepenapple";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> set1 = new HashSet<>();
        for (String str: wordDict)
            set1.add(str);
//        for (String a: set1)
//            System.out.println(a);
        boolean[] dp= new boolean[s.length()+1];
        dp[0] =true;
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<i;j++){
                if (dp[j] && set1.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wzh
 * @time: 2020/7/9 21:27
 * @description:
 */
public class Medium_respace {
    public static void main(String[] args){

    }
    public static int respace(String[] dictionary, String sentence){
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i] = dp[i-1]+1;
            for (int index=0;index<i;index++){
                if (dict.contains(sentence.substring(index, i))){
                    dp[i] = Math.min(dp[i], dp[index]);
                }
            }
        }
        return dp[n];
    }
}

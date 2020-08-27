package LeetCode;

import java.util.HashSet;

/**
 * @author: wzh
 * @time: 2020/8/26 17:10
 * @description:
 */
public class Medium_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < chars.length){
            if(!set.contains(chars[right])){
                set.add(chars[right]);
                right++;
            }else{
                while(chars[left]!=chars[right]){
                    set.remove(chars[left]);
                    left++;
                }
                left++;
                right++;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
}

package BroadView;

import java.util.HashSet;
import java.util.Set;

public class ex48_lengthOfLongestSubstring {
    public static void main(String[] args){
//        String s = "abcabcbb";
        String s = "pwwke";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int max = 0;
        int thismax = 0;
        int begin = 0, end = 0;
        for (int i=0;i<ch.length;i++){
            if (!set.contains(ch[i])){
                set.add(ch[i]);
                thismax++;
            }
            else {
                end = i;
                max = Math.max(max, thismax);
                while (ch[begin]!=ch[end]){
                    set.remove(ch[begin]);
                    begin++;
                    thismax--;
                }
                set.remove(ch[begin]);
                begin++;
                thismax--;
                i--;
            }
        }
        max = Math.max(max, thismax);
        return max;
    }
}

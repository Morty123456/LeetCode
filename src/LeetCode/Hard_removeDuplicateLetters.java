package LeetCode;

import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/8/23 10:13
 * @description:
 */
public class Hard_removeDuplicateLetters {
    public static void main(String[] args) {
        String s = "thesqtitxyetpxloeevdeqifkz";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        boolean[] InStcak = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for(char ch : chars){
            count[ch-'a']++;
        }
        for(char ch : chars){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                if(InStcak[ch-'a']){
                    count[ch-'a']--;
                    continue;
                }
                while(!stack.isEmpty() && ch < stack.peek() && count[stack.peek()-'a'] > 0){
                    char p = stack.pop();
//                    count[p-'a']--;
                    InStcak[p-'a']=false;
                }
                if(!InStcak[ch-'a'])
                    stack.push(ch);
            }
            count[ch-'a']--;
            InStcak[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

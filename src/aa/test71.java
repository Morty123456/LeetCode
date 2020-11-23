package aa;

import java.util.Deque;
import java.util.LinkedList;

public class test71 {
    public static void main(String[] args) {
        String num = "1432219";
//        System.out.println(removeKdigits2(num, 3));
        System.out.println(removeKdigits2("123456789000", 9));
    }
    public static String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        for (int i=0; i<num.length()-1; i++){
            if (chars[i]-chars[i+1]>0 && k>0){
                chars[i] = 'f';
                k--;
            }
        }
        int end = num.length()-1;
        while (end>=0 && chars[end]=='0')
            end--;
        while (k-->0 && end>=0){
            if (chars[end]=='f')
                k++;
            chars[end] = 'f';
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chars){
            if (ch=='f' || (ch=='0' && sb.length()==0))
                continue;
            sb.append(ch);
        }
        return sb.length()==0?"0":sb.toString();
    }
    public static String removeKdigits2(String num, int k){
        Deque<Character> deque = new LinkedList<Character>();
        for (char ch : num.toCharArray()){
            while (!deque.isEmpty() && k>0 && deque.peekLast()>ch){
                deque.pollLast();
                k--;
            }
            deque.offerLast(ch);
        }
        while (k-->0)
            deque.pollLast();
        StringBuilder sb = new StringBuilder();
        boolean BeginIsZero = true;
        while (!deque.isEmpty()){
            char ch = deque.pollFirst();
            if (BeginIsZero && ch=='0')
                continue;
            BeginIsZero = false;
            sb.append(ch);
        }
        return sb.length()==0?"0":sb.toString();
    }
}

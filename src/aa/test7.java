package aa;

import java.util.Scanner;
import java.util.Stack;

public class test7 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
    public static int solution(String str){
        int[] num = new int[str.length()];
        char[] chars = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<str.length(); i++){
            if (chars[i]=='(')
                stack.push(i);
            else if (!stack.isEmpty()){
                num[i] = 1;
                num[stack.pop()]=1;
            }
        }
        int max = 0;
        int left = 0;
        int right = 0;
        for (left=0; left<num.length; left++){
            if (num[left]==0)
                continue;
            right = left;
            while (right<num.length && num[right]==1){
                right++;
            }
            max = Math.max(right-left, max);
            left = right;
        }
        return max;
    }
}

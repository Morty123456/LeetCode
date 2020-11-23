package aa;

import java.util.Stack;

public class test74 {
    public static void main(String[] args) {
        String[] s = {"T && F", "T || F && F || F", "!F || T && T"};
        calculate(s);
    }
    public static void calculate(String[] inputs){

        for (String str : inputs){
            System.out.println(solution(str));
        }
    }
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch=='!' || ch=='('){
                stack.push(ch);
            }else if (ch=='F' || ch=='T'){
                if (stack.isEmpty() || stack.peek()=='(')
                    stack.push(ch);
                else if (stack.peek()=='!'){
                    stack.pop();
                    if (ch=='T')
                        stack.push('F');
                    else
                        stack.push('T');
                }
            }else if (ch=='|'){
                if (stack.isEmpty())
                    continue;
                if (stack.peek()=='T')
                    return "T";
                else
                    stack.pop();
            }else if (ch=='&'){
                if (stack.isEmpty())
                    continue;
                if (stack.peek()=='F')
                    return "F";
                else
                    stack.pop();
            }
        }
        return stack.pop()+"";
    }
}

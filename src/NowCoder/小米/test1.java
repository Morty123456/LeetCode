package NowCoder.小米;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/9/15 19:03
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (solution(str))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
    public static boolean solution(String str){
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars){
            if (ch=='(' || ch=='[' || ch=='{')
                stack.push(ch);
            else if(stack.isEmpty() || (ch==')'&&stack.pop()!='(') || (ch==']'&&stack.pop()!='[') ||(ch=='}'&&stack.pop()!='{'))
                return false;
        }
        return stack.isEmpty();
    }
}

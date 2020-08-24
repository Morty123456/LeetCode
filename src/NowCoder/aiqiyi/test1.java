package NowCoder.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/8/23 14:30
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        for (i=0;i<s.length();i++){
            char ch = chars[i];
            if (ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else if(stack.isEmpty()){
                System.out.println("False");
                break;
            }else if (ch==')' && stack.pop()!='('){
                System.out.println("False");
                break;
            }else if (ch==']' && stack.pop()!='['){
                System.out.println("False");
                break;
            }else if (ch=='}' && stack.pop()!='{'){
                System.out.println("False");
                break;
            }
        }
        if (i==chars.length)
            System.out.println("True");
    }
}

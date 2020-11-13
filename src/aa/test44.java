package aa;

import java.util.Scanner;
import java.util.Stack;

public class test44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<n; i++){
            String str = sc.nextLine();
            if (judge(str))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static boolean judge(String str){
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (stack.isEmpty()){
                stack.push(ch);
            }else if (ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }else if ((ch=='}' && stack.peek()=='{') || (ch==')' && stack.peek()=='(') || (ch==']' && stack.peek()=='[') ){
                stack.pop();
            }else
                return false;
        }
        return stack.isEmpty();
    }
}

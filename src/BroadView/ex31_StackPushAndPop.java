package BroadView;

import java.util.Stack;

public class ex31_StackPushAndPop {
    public static void main(String[] args){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        int[] popped2 = {4,3,5,1,2};
        System.out.print(validateStachSequences2(pushed, popped2));
    }
    //答案
    public static boolean validateStachSequences2(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int n = popped.length;
        int j=0;
        for (int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && j<n && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    //自己写的
    public static boolean validateStackSequences(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int prePushed = 0, prePopped = 0;
        while (prePopped<popped.length){
            if (stack.isEmpty())
                stack.push(pushed[prePushed++]);
            while(!stack.isEmpty() && prePopped<popped.length && stack.peek()==popped[prePopped]){
                stack.pop();
                prePopped++;
            }
            while(!stack.isEmpty() && prePushed<pushed.length && stack.peek()!=popped[prePopped]){
                stack.push(pushed[prePushed]);
                prePushed++;
            }
            if(!stack.isEmpty() && popped[prePopped]!=stack.peek())
                return false;
        }
        return true;
    }
}

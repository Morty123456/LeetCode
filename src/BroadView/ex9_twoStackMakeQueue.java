package BroadView;

import java.util.Stack;

public class ex9_twoStackMakeQueue {
    public static void main(String[] args){
        ex9_twoStackMakeQueue queue = new ex9_twoStackMakeQueue();
        queue.CQueue();
//        System.out.println(queue.deleteHead());
        queue.appendTail(3);
//        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
    Stack<Integer> stack1, stack2;
    public void CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail(int val){
        stack1.push(val);
    }
    public int deleteHead(){
        if (!stack2.isEmpty())
            return stack2.pop();
        else if (!stack1.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
        else
            return -1;
    }
}

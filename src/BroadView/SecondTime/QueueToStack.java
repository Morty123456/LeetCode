package BroadView.SecondTime;

import java.util.Stack;

public class QueueToStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        QueueToStack qs = new QueueToStack();
        qs.appendTail(3);
        System.out.println(qs.deleteHead());
        System.out.println(qs.deleteHead());
    }
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public QueueToStack(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void appendTail(int value){
        stackIn.push(value);
    }
    public int deleteHead(){
        if (!stackOut.isEmpty())
            return stackOut.pop();
        if (stackIn.isEmpty())
            return -1;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }
}

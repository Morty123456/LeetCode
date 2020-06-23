package BroadView.SecondTime;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wzh
 * @time: 2020/6/23 16:06
 * @description:队列的最大值
 */
public class MaxQueue {
    public static void main(String[] args){
        MaxQueue mq = new MaxQueue();
//        mq.push_back(7);
//        System.out.println(mq.pop_front());
//        System.out.println(mq.pop_front());
//        System.out.println(mq.pop_front());
//        mq.push_back(5);
//        System.out.println(mq.pop_front());
//        System.out.println(mq.max_value());
//        mq.push_back(8);
//        mq.push_back(8);
//        mq.push_back(5);
//        mq.push_back(6);
//        System.out.println(mq.max_value());
//        System.out.println(mq.pop_front());
//        System.out.println(mq.max_value());
//        System.out.println(mq.pop_front());
//        System.out.println(mq.max_value());
//        System.out.println(mq.pop_front());
//        System.out.println(mq.max_value());
//        System.out.println(mq.pop_front());
//        System.out.println(mq.max_value());
        String[] cz = {"max_value","pop_front","max_value","push_back",
                "max_value","pop_front","max_value","pop_front","push_back",
                "pop_front","pop_front","pop_front","push_back",
                "pop_front","max_value","pop_front","max_value"};
        int[] cs = {46,868,525};
        int j = 0;
        for (int i=0;i<cz.length;i++){
            switch (cz[i]){
                case "max_value":
                    System.out.println(mq.max_value());
                    break;
                case "pop_front":
                    System.out.println(mq.pop_front());
                    break;
                case "push_back":
                    mq.push_back(cs[j]);
                    j++;
                    break;
            }
        }
    }
    Queue<Integer> queue;
    LinkedList<Integer> maxQueue;
    public MaxQueue(){
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }
    public int max_value(){
        if (maxQueue.isEmpty())
            return -1;
        else
            return maxQueue.getFirst();
    }
    public void push_back(int value){
        queue.add(value);
        if (maxQueue.isEmpty()){
            maxQueue.addLast(value);
        }else {
            while (!maxQueue.isEmpty() && value > maxQueue.getLast()){
                maxQueue.removeLast();
            }
            maxQueue.addLast(value);
        }
    }
    public int pop_front(){
        if (queue.isEmpty())
            return -1;
        else if(queue.peek().equals(maxQueue.getFirst())){
            maxQueue.removeFirst();
            return queue.poll();
        }else
            return queue.poll();
    }
}

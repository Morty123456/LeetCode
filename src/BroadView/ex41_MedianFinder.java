package BroadView;

import java.util.Collections;
import java.util.PriorityQueue;

public class ex41_MedianFinder {
    public static void main(String[] args){
        int a = 1, b = 2;
        System.out.println((a+b)/2 +"  "+ (a+b)*0.5);
//        MedianFinder();
//        addNum(1);
//        addNum(2);
//        System.out.println(findMedian());
//        addNum(3);
//        System.out.println(findMedian());
    }
    static PriorityQueue<Integer> maxHeap, minHeap;
    public static void MedianFinder(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public static void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size()>maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    public static double findMedian(){
        if (maxHeap.size()==minHeap.size())
            return (maxHeap.peek()+minHeap.peek())*0.5;
        return maxHeap.peek();
    }
}

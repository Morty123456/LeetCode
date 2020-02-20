package LeetCode;

import java.util.ArrayDeque;

public class Hard_SlidingWindowMaximum {
    public static void main(String[] args){
        int[] nums = {};
        int k = 0;
        int[] max = maxSlidingWindow2(nums, k);
        for (int a: max)
            System.out.println(a);
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        int length = nums.length;
        int[] max = new int[length-k+1];
        if (length==0)
            return new int[0];
        for (int i=0;i<length-k+1;i++){
            max[i] = findMax(nums, k, i);
        }
        return max;
    }
    public static int findMax(int[] nums, int k, int begin){
        int max = nums[begin];
        for (int i=begin;i<begin+k;i++){
            if (nums[i]>max)
                max = nums[i];
        }
        return max;
    }
    //复杂度为n的算法
    public static int[] maxSlidingWindow2(int[] nums, int k){
        if (nums==null || k<=0)
            return new int[0];
        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int index = 0;
        for (int i=0;i<nums.length;i++){
            while (!deque.isEmpty() && deque.peek()<i-k+1)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                deque.pollLast();
            deque.offer(i);
            if (i>=k-1)
                res[index++] = nums[deque.peek()];
        }
        return res;
    }
}

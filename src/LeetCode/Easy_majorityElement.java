package LeetCode;

import java.util.Stack;

public class Easy_majorityElement {
    public static void main(String[] args){
        int[] nums = {3,3,4};
        System.out.println(majorityElement2(nums));
    }
    // 投票算法
    public static int majorityElement2(int[] nums){
        int count = 0;
        int res = 0;
        for (int num : nums){
            if (count==0){
                count++;
                res = num;
            }
            else
                count += (res==num ? 1 : -1);
        }
        return res;
    }
    // 使用 stack
    public static int majorityElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for (int num : nums){
            if (stack.isEmpty() || stack.peek()==num)
                stack.push(num);
            else
                stack.pop();
        }
        return stack.peek();
    }
}

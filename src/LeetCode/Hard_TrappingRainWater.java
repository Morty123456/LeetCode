package LeetCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 接雨水问题
 * @author: wzh
 * @create: 2020-01-13 09:09
 **/
public class Hard_TrappingRainWater {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i=0;i<n;i++)
            height[i]=sc.nextInt();
        Hard_TrappingRainWater rain = new Hard_TrappingRainWater();
//        System.out.print(rain.trap(height));
        System.out.println(trap2(height));
    }
    public int trap(int[] height){
        int length = height.length;
        int getRain = 0;
        for (int i=1;i<length-1;i++){
            int[] lr = getHeight(height, i);
            if (lr[0] > height[i] && lr[1] > height[i]){
                getRain += Math.min(lr[0], lr[1]) - height[i];
            }
        }
        return getRain;
    }
    public int[] getHeight(int[] height, int local){
        int[] he = new int[2];
        he[0] = he[1] = height[local];
        for (int i=local;i>=0;i--){
            if (height[i]>he[0])
                he[0] = height[i];
        }
        for (int i=local;i<height.length;i++){
            if (height[i]>he[1])
                he[1] = height[i];
        }
        return he;
    }
    public static int trap2(int[] height){
        Stack<Integer> stack = new Stack<>();
        int getRain = 0;
        for (int i=0;i<height.length;i++){
            if (stack.isEmpty() || height[stack.peek()]>=height[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                    int t = stack.pop();
                    if (!stack.empty()){
                        int l = stack.peek();
                        getRain += (Math.min(height[l], height[i])-height[t])*(i-l-1);
                    }
                }
                stack.push(i);
            }
        }
        return getRain;
    }
}

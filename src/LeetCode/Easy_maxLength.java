package LeetCode;

import java.util.HashSet;

/**
 * @author: wzh
 * @time: 2020/9/4 22:30
 * @description:
 */
public class Easy_maxLength {
    public static void main(String[] args) {
        int[] num = {2,3,4,5};
        System.out.println(maxLength(num));
    }
    public static int maxLength (int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while(right < arr.length){
            while(right<arr.length && !set.contains(arr[right])){
                set.add(arr[right]);
                right++;
            }
            max = Math.max(max, right-left);
            while(right<arr.length && arr[left]!=arr[right]){
                set.remove(arr[left]);
                left++;
            }
        }
        return max;
    }
}

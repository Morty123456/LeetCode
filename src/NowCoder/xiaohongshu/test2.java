package NowCoder.xiaohongshu;

import java.util.Arrays;

/**
 * @author: wzh
 * @time: 2020/9/6 18:51
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 10, 7, 9, 8, 8, 12, 13, 14, 19};
        int[] res = solution2(num);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] solution(int[] arr){
        int[] num = Arrays.copyOf(arr, arr.length);
        Arrays.sort(num);
        int left = 0, right = arr.length-1;
        int[] res = {0,arr.length};

        while(left<right){
            if (num[left]==arr[left])
                left++;
            else{
                break;
            }
        }
        res[0] = left;
        while (left<right){
            if(num[right]==arr[right]){
                right--;
            }else {
                break;
            }
        }
        res[1] = right;
        if (res[0]<res[1])
            return res;
        int[] resFalse = {-1,-1};
        return resFalse;
    }
    public static int[] solution2(int[] arr){
        int left = 0, right = arr.length-1;
        left = 1;
        int[] res = {-1, -1};
        while (left<arr.length){
            if (arr[left]>=arr[left-1]){
                left++;
            }else
                break;
        }
        //数组是有序的
        if (left==arr.length)
            return res;
        int minLocal = left;
        for (int i = left; i < arr.length; i++) {
            if (arr[i]<=arr[minLocal]){
                minLocal = i;
            }
        }
        int min = arr[minLocal];
        for (int i=0;i<left;i++){
            if (min<arr[i]) {
                res[0] = i;
                break;
            }
        }
        right = arr.length-2;
        while (right>=0){
            if (arr[right]<=arr[right+1]){
                right--;
            }else
                break;
        }
        int maxLocal = right;
        for (int i = right; i >=0 ; i--) {
            if (arr[i]>=arr[maxLocal])
                maxLocal = i;
        }
        int max = arr[maxLocal];
        for (int i=arr.length-1;i>=right;i--){
            if (arr[i]<max){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}

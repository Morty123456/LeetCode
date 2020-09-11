package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/9 21:40
 * @description:
 */
public class Medium_LIS {
    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] res = solution(arr);
        for (int a : res){
            System.out.print(a+" ");
        }
    }
    public static int[] solution(int[] arr){
        int n = arr.length;
        int[] end = new int[n+1];
        int[] dp = new int[n];
        int len = 1;
        end[1] = arr[0];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (end[len] < arr[i]){
                end[++len] = arr[i];
                dp[i] = len;
            }else {
                int l = 0;
                int r = len;
                while (l<r){
                    int mid = (l+r)>>1;
                    if (end[mid] >= arr[i]){
                        r = mid-1;
                    }else {
                        l = mid+1;
                    }
                    end[i] = arr[i];
                    dp[i] = l;
                }
            }
        }
        int[] res = new int[len];
        for (int i = n-1; i >=0 ; i--) {
            if (dp[i] == len){
                res[--len] = arr[i];
            }
        }
        return res;
    }
}

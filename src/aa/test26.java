package aa;

import java.util.ArrayList;
import java.util.Arrays;

public class test26 {
    public static void main(String[] args) {
        int[] num = {2,1,5,3,6,4,8,9,7};
        int[] res = LIS(num);
        int i = 0;
    }
    public static int[] LIS(int[] arr){
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        ArrayList<Integer>[] lists = new ArrayList[len];
        lists[0] = new ArrayList();
        lists[0].add(arr[0]);
        for (int i=1; i<len; i++){
            int max = -1;
            for (int j=0; j<i; j++){
                if (arr[i]>arr[j] && (max<0 || dp[j]>dp[max])){
                    max = j;
                }
            }
            if (max>=0){
                lists[i] = new ArrayList<>(lists[max]);
                dp[i] = dp[max]+1;
                lists[i].add(arr[i]);
            }else {
                lists[i] = new ArrayList<>();
                lists[i].add(arr[i]);
            }

        }
        return new int[0];
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/7 14:19
 * @description:
 */
public class Medium_maxProduct {
    public static void main(String[] args) {
        double[] arr = {0.1,0.0,3.0,-2.0,0.9,-1.3,5.0,-4.4};
        System.out.println(maxProduct(arr));
    }
    public static double maxProduct(double[] arr) {
        int len = arr.length;
        double[] min = new double[len];
        double[] max = new double[len];
        min[0] = arr[0];
        max[0] = arr[0];
        double maxAll = arr[0];
        for(int i=1; i<len; i++){
            min[i] = Math.min(arr[i], Math.min(arr[i]*max[i-1], arr[i]*min[i-1]));
            max[i] = Math.max(arr[i], Math.max(arr[i]*max[i-1], arr[i]*min[i-1]));
            maxAll = Math.max(max[i], maxAll);
        }
        return maxAll;
    }
}

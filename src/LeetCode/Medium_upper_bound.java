package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/4 21:49
 * @description:
 */
public class Medium_upper_bound {
    public static void main(String[] args) {
        int n = 10, v = 2;
        int[] a = {1,1,2,3,7,7,7,9,9,10};
        System.out.println(upperBound(n, v, a));
    }
    public static int upperBound(int n, int v, int[] a){
        int left = 0, right = n-1;
        if (a[n-1] < v){
            return n+1;
        }
        while (left<=right){
            int mid = (left+right)/2;
            if (a[mid]<v){
                left = mid+1;
            }else{
                if (mid==0 || a[mid-1]<v){
                    return mid;
                }
                right = mid-1;
            }
        }
        return n+1;
    }
}

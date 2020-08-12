package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/12 7:33
 * @description:
 */
public class Hard_candy {
    public static void main(String[] args) {
        int[] num = {1,3,2,2,1};
        System.out.println(candy(num));
    }
    public static int candy(int[] ratings){
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = 1;
            right[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (ratings[i]>ratings[i-1])
                left[i] = left[i-1]+1;
        }
        for (int i = len-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1])
                right[i] = right[i+1]+1;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + Math.max(left[i], right[i]);
        }
        return sum;
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/4 18:32
 * @description:
 */
public class Medium_singleNumber2 {
    public static void main(String[] args) {
        int[] num = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(num));
    }
    public static int singleNumber(int[] nums){
        int[] count = new int[32];
        for (int num : nums){
            for (int i = 0; i < 32; i++) {
                count[i] += num&1;
                num >>>= 1;
            }
        }
        int sum = 0;
        int now = 1;
        for (int c : count){
            if (c%3!=0){
                sum += now;
            }
            now <<= 1;
        }
        return sum;
    }
}

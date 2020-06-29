package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/6/28 14:43
 * @description:
 */
public class ex_56_singleNumber {
    public static void main(String[] args){
        int[] num = {5,2,2,2,5,5,4};
        System.out.println(singleNumber(num));
    }
    public static int singleNumber(int[] nums){
        int[] count = new int[32];
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<32;j++){
                count[j] += nums[i]&1;
                nums[i] >>>= 1;
            }
        }
        int res = 0;
        for (int i=0;i<32;i++){
            res <<= 1;
            if (count[31-i]%3==1){
                res |= 1;
            }
        }
        return res;
    }
}

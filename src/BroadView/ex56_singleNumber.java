package BroadView;

import java.util.HashMap;

public class ex56_singleNumber {
    public static void main(String[] args){
        int[] nums = {3,4,3,3};
        System.out.println(singleNumber(nums));
    }
    //把所有数字的二进制加起来
    //三个数字相同，则那个位置1的个数肯定都是3的倍数
    //如果那位有单独的那个数，则有余数为1
    public static int singleNumber(int[] nums){
        int[] bits = new int[32];
        for (int num : nums){
            int getBit = 1;
            for (int j=31;j>=0;j--){
                if ((num&getBit)!=0)
                    bits[j]++;
                getBit = getBit << 1;
            }
        }
        int res = 0;
        int mark = 1;
        for (int i=31;i>=0;i--){
            res += bits[i]%3 * mark;
            mark = mark<<1;
        }
        return res;
    }
}

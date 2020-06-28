package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/6/28 14:19
 * @description:
 */
public class ex_55_singleNumbers {
    public static void main(String[] args){
        int[] num = {1,2,10,4,1,4,3,3};
        int[] res = singleNumbers(num);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] singleNumbers(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum ^= num;
        }
        int i = 1;
        while ((sum&i) ==0){
            i <<= 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int num : nums){
            if ((num&i)==0){
                num1 ^= num;
            }else {
                num2 ^= num;
            }
        }
        int[] res = new int[2];
        res[0] = num1;
        res[1] = num2;
        return res;
    }
}

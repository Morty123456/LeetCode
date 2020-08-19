package NowCoder.huawei;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/12 18:49
 * @description:
 */
public class huawei1 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(",");
        int len = strs.length;
        int[] num = new int[len];
        for (int i=0;i<strs.length;i++){
            num[i] = strToNum(strs[i]);
        }
        boolean flage = change(num);
        if (flage)
            System.out.println("true,"+count);
        else
            System.out.println("false,"+count);
    }
    public static boolean change(int[] nums){
        int[] change = new int[2];
        for (int num : nums){
            count++;
            if (num!=5 && num!=10 && num!=20)
                return false;
            else {
                if (num==5)
                    change[0]++;
                else if (num==10 && change[0]>0){
                    change[0]--;
                    change[1]++;
                }
                else if (num==20){
                    if (change[1]>0 && change[0]>0){
                        change[1]--;
                        change[0]--;
                    }else if (change[0]>=3){
                        change[0] = change[0]-3;
                    }else
                        return false;
                }
                else
                    return false;
            }
        }
        return true;
    }
    public static int strToNum(String str){
        int sum = 0;
        int c = 1;
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i>=0;i--){
            sum = sum + (chars[i]-'0')*c;
            c *= 10;
        }
        return sum;
    }
}

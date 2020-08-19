package NowCoder.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/12 18:49
 * @description:
 */
public class hauwei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(",");
        String str = strs[0];
        int target = strToNum(strs[1]);
        System.out.println(reverseStr(str, target));
    }
    public static String reverseStr(String str, int num){
        int len = str.length();
        char[] chars = str.toCharArray();
        int left = 0, right = num-1;
        StringBuilder[] builders = new StringBuilder[num];
        for (int i=0;i<num;i++)
            builders[i] = new StringBuilder();
        int count = 0;
        boolean flageA = true, flageB = true;
        boolean goLOrR = true;
        while (count<len){
            if (goLOrR){
                if ((left<num/2 && flageA) || (left==0 && !flageA)) {
                    if (!flageA)
                        flageA = true;
                    builders[left].append(chars[count]);
                    left++;
                }
                else if (left==num/2){
                    builders[left].append(chars[count]);
                    left--;
                    flageA = false;
                }
                else if (left>0 && !flageA){
                    builders[left].append(chars[count]);
                    left--;
                }
                count++;
                goLOrR = false;
            }else {
                if ((right>num/2 && flageB) || (right==num-1 && !flageB)){
                    if (!flageB)
                        flageB = true;
                    builders[right].append(chars[count]);
                    right--;
                    count++;
                }
                else if (right==num/2){
                    right++;
                    flageB = false;
                }
                else if (right<num-1 && !flageB){
                    builders[right].append(chars[count]);
                    right++;
                    count++;
                }
                goLOrR = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : builders)
            sb.append(stringBuilder);
        return sb.toString();
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

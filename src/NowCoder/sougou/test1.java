package NowCoder.sougou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/5 18:31
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        num[2] = sc.nextInt();
        Arrays.sort(num);
        int sum = 0;
        sum += num[0];
        int a = num[1]-num[0], b = num[2]-num[0];
        if ((b-a)/3>=a){
            sum += a;
            b -= 3*a;
            sum += b/5;
        }else{
            int first = (b-a)/3;
            sum += first;
            b -= first*3;
            a -= first;
            sum += Math.min(b,a)/2;
        }
        System.out.println(sum);
    }
    /**
     * public int numberofprize (int aa, int bb, int cc) {
     *         // write code here
     *         int[] num = new int[3];
     *         num[0] = aa;
     *         num[1] = bb;
     *         num[2] = cc;
     *         Arrays.sort(num);
     *         int sum = 0;
     *         sum += num[0];
     *         int a = num[1]-num[0], b = num[2]-num[0];
     *         while (a+b>4 && a!=0){
     *             b -= 3;
     *             a -= 1;
     *             sum++;
     *             if (a>b){
     *                 a = (a+b)-(b=a);
     *             }
     *         }
     *         if (a==0){
     *             sum += b/5;
     *         }
     *         if (a==2 && b==2){
     *             sum += 1;
     *         }
     *         return sum;
     *     }
     */
}

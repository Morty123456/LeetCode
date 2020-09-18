package NowCoder.中兴;

import java.util.Scanner;
/**
 * @author: wzh
 * @time: 2020/9/17 10:52
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<n; i++){
            String str = sc.nextLine();
            System.out.println(solution(str));
        }
    }
    public static int solution(String str){
        String[] strs = str.split(" ");
        String str1 = strs[0];
        int sum = 0;
        int begin = strToInt(strs[1]);
        int end = strToInt(strs[2]);
        for (int i=begin; i<=end; i++){
            sum += xToTen(str1, i);
        }
        return sum&1;
    }
    public static int xToTen(String str, int num){
        char[] chars = str.toCharArray();
        int len = chars.length;
        int local = 0;
        int sum = 0;
        for (int i=len-1; i>=0; i--){
            int n = 0;
            if (chars[i]>='0' && chars[i]<='9')
                n = chars[i]-'0';
            else{
                n = chars[i]-'A'+10;
            }
            if (n%2!=0){
                sum += 1;
            }
            local++;
        }
        return sum&1;
    }
    public static int strToInt(String str){
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char ch : chars){
            sum = sum*10 + ch-'0';
        }
        return sum;
    }
}

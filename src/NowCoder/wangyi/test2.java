package NowCoder.wangyi;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/12 14:17
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
    public static int solution(String str){
        int len = str.length();
        char[] chars = str.toCharArray();
        int max  = 0;
        for (int i=0; i<len; i++){
            if (len-i<=max)
                break;
            for (int j=1; j<len; j++){
                if (j-i+1<=max)
                    continue;
                if (judge(chars, i, j)){
                    max = Math.max(j-i+1, max);
                }
            }
        }
        return max;
    }
    public static boolean judge(char[] chars, int left, int right){
        int[] count = new int[6];
        for (int i=left; i<=right; i++){
            if (chars[i]=='a'){
                count[0]++;
            }else if(chars[i]=='b'){
                count[1]++;
            }else if (chars[i]=='c'){
                count[2]++;
            }else if(chars[i]=='x'){
                count[3]++;
            }else if (chars[i]=='y'){
                count[4]++;
            }else if (chars[i]=='z'){
                count[5]++;
            }
        }
        boolean f = true;
        for (int i : count){
            f &= (i%2==0);
        }
        return f;
    }
}

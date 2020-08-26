package NowCoder.ali;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/26 9:00
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
//        String[] strs = new String[n];
        for (int i=0;i<n;i++){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            System.out.println(solution(strs[1], strs[2], 0, 0));
        }
    }
    public static int solution(String a, String b, int sum, int local){
        if(local>=Math.min(a.length(), b.length()) || a.charAt(local)>b.charAt(local)){
            return 0;
        }else if (a.charAt(local)==b.charAt(local)){
            return solution(a,b,sum, local+1);
        }else if (a.charAt(local)==b.charAt(local)-1){
            if (local>0)
                return 1;
            int len = a.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append("a");
            }
            String test = sb.toString();
            int left = solution(a, test, sum, local+1);
            int right = solution(test, b, sum, local+1);
            return left+right;
        }else {
            int aa = (b.charAt(local)-a.charAt(local)-1);
            int bb = (int)Math.pow(26, a.length()-local-1);
            sum = sum + aa*bb;
//            sum += (b.charAt(local)-a.charAt(local)-1) * Math.pow(26, a.length()-local-1);
            sum += solution(a,b,sum, local+1);
        }
        return sum;
//        for (int i = 0; i < strs[0].length(); i++) {
//            if (strs[0].charAt(i)<strs[1].charAt(i)){
//                break;
//            }else {
//                if (strs[0].charAt(i)-strs[1].charAt(i)>1){
//                    sum += strs[0].charAt(i)-strs[1].charAt(i)
//                }
//            }
//        }
    }
}

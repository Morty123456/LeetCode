package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/3 7:32
 * @description:
 */
public class Easy_addStrings {
    public static void main(String[] args){
        String s1 = "12345";
        String s2="111";
        System.out.println(addStrings(s1, s2));
    }
    public static String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int s = 0;
        int i = num1.length()-1, j = num2.length()-1;
        while (i>=0 || j>=0 || s!=0){
            if (i>=0)
                s += num1.charAt(i--)-'0';
            if (j>=0)
                s += num2.charAt(j--)-'0';
            sb.append(s%10);
            s /= 10;
        }
        return sb.reverse().toString();
    }
}

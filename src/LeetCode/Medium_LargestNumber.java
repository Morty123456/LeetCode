package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: 拼接字符串的最大值
 * @author: wzh
 * @create: 2019-12-21 16:54
 **/
public class Medium_LargestNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solution(a));
    }
    public static String solution(int[] a){
        if (a.length==0 || a==null)
            return "";
        int n = a.length;
        String[] num = new String[n];
        for (int i=0;i<n;i++)
            num[i] = String.valueOf(a[i]);
        //重写排序
        Arrays.sort(num , new Comparator<String>() {
            public int compare(String o1, String o2){
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        });
        String list = "";
        if (num[0].equals("0"))
            return "0";
        for (String str : num)
            list += str;
        return list;
    }
}

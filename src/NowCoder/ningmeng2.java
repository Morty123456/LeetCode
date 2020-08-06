package NowCoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/6 8:48
 * @description:
 */
public class ningmeng2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c>='0' && c<='9')
                list.add(c-'0');
        }
        int t = list.removeLast();
        int[] a = new int[list.size()];
        for (int i=0;i<a.length;i++)
            a[i] = list.removeFirst();
        System.out.println(minSunOfLengths(a, t));
    }
    public static int minSunOfLengths(int[] A, int T){
        int length = A.length;
        if (length==1)
            return -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=length-2;i++){
            int left = find(A, 0, i, T);
            if (left+1<0)
                continue;
            int right = find(A, i+1, length-1, T);
            if (right+1<0)
                continue;
            if (min > (left+right)){
                min = left+right;
                if (min==2)
                    return 2;
            }
        }
        return min<0 ? -1: min;
    }
    public static int find(int[] a, int begin, int end, int t){
        int min = Integer.MAX_VALUE;
        int left = begin, right = begin;
        int sum = a[right];
        while (right <= end){
            if (sum==t && (right-left+1) < min){
                min = right-left+1;
                if (min==1 || right==end)
                    return min;
                sum += a[++right];
            }
            else if (sum>t){
                sum -= a[left];
                left++;
            }else {
                right++;
                if (right<=end){
                    sum += a[right];
                }
            }
        }
        return min;
    }
}

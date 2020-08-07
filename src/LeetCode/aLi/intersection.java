package LeetCode.aLi;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: wzh
 * @time: 2020/8/7 14:31
 * @description:
 */
public class intersection {
    public static void main(String[] args){
        int[] a = {4,9,5};
        int[] b = {9,4,9,8,4};
        int[] num = intersection(a, b);
        for (int n : num)
            System.out.print(n+" ");
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        LinkedList<Integer> list = new LinkedList<>();
        int len1 = nums1.length, i=0;
        int len2 = nums2.length, j=0;
        while(i<len1 && j<len2){
            if(nums1[i]==nums2[j]){
                if(list.isEmpty() || list.getLast() != nums1[i])
                    list.add(nums1[i]);
                else{
                    i++;j++;
                }
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] num = new int[list.size()];
        for (int m=0;m<num.length;m++){
            num[m] = list.get(m);
        }
        return num;
    }
}

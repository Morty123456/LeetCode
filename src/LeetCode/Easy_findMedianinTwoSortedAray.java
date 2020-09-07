package LeetCode;

public class Easy_findMedianinTwoSortedAray {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4};
        int[] num2 = {3,4,5,6};
        System.out.println(findMedianinTwoSortedAray(num1, num2));
    }
    public static int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int n = arr1.length;
        int count = n;
        int l1 = 0, l2 = 0;
        while(l1<n && l2<n && count-->0){
            if(count==0)
                return Math.min(arr1[l1], arr2[l2]);
            if(arr1[l1]<arr2[l2])
                l1++;
            else
                l2++;
        }
        return 0;
    }
}

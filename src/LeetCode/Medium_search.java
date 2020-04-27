package LeetCode;

public class Medium_search {
    public static void main(String[] args){
        int[] num = {4,5,6,7,0,1,2};
        System.out.println(search(num, 4));
    }
    public static int search(int[] nums, int target){
        if (nums.length==0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]==target)
                return mid;
            else if(nums[mid]<nums[right]){
                if (nums[mid]<target && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
            else {
                if (nums[left]<=target && target<=nums[mid]){
                    right=mid-1;
                }
                else
                    left=mid+1;
            }
        }
        return -1;
    }
}

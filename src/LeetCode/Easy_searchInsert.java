package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/17 8:42
 * @description:
 */
public class Easy_searchInsert {
    public static void main(String[] args){
        int[] num = {1,3,5,6};
        System.out.println(searchInsert(num, 0));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                if(mid==nums.length-1 || nums[mid+1]>target)
                    return mid+1;
                left = mid+1;
            }else{
                if(mid==0)
                    return 0;
                else if(nums[mid-1]<target)
                    return mid;
                right = mid-1;
            }
        }
        return 0;
    }
}

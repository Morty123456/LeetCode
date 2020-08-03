package LeetCode.aLi;

/**
 * @author: wzh
 * @time: 2020/8/3 21:30
 * @description:
 */
public class findKthLargest {
    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
    public static int findKthLargest(int[] nums, int k){
        //构建小顶堆
        for (int i=k/2-1;i>=0;i--)
            adjustHeap(nums, i, k-1);
        for (int i=k;i<nums.length;i++){
            if (nums[i]>nums[0]){
                nums[0] = nums[i];
                adjustHeap(nums, 0, k-1);
            }
        }
        return nums[0];
    }
    public static void adjustHeap(int[] nums, int begin, int end){
        int temp = nums[begin];
        for (int k=2*begin+1;k<=end;k = k*2+1){
            if (k+1 <= end && nums[k+1]<nums[k])
                k++;
            if (nums[k] < temp){
                nums[begin] = nums[k];
                begin = k;
            }
            else
                break;
        }
        nums[begin] = temp;
    }

}

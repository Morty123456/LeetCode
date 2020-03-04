package BroadView;

public class ex59_MaximumSidingWindow {
    public static void main(String[] args){
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        int[] arr = maxSlidingWindow(nums, k);
        for (int a: arr)
            System.out.print(a+" ");
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int length = nums.length;
        int[] res = new int[length-k+1];
        int maxLocal = 0;
        for(int i=0;i<k;i++)
            maxLocal = nums[i] >= nums[maxLocal] ? i : maxLocal;
        res[0] = nums[maxLocal];
        int start = k, end = 0;
        for(start=k;start<length;start++){
            if(nums[start]>=nums[maxLocal]){
                maxLocal = start;
            }
            if(end==maxLocal){
                maxLocal = end+1;
                for(int i=end+1;i<=start;i++){
                    maxLocal = nums[i]>=nums[maxLocal] ? i : maxLocal;
                }
            }
            res[start-k+1] = nums[maxLocal];
            end++;
        }
        return res;
    }
}

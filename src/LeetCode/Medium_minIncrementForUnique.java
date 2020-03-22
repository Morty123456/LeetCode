package LeetCode;

public class Medium_minIncrementForUnique {
    public static void main(String[] args){
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
    public static int minIncrementForUnique(int[] nums){
        int count = 0;
        int length = nums.length;
        for (int i=1;i<length;i++){
            int pre = i-1;
            int current = nums[i];
            while (pre>=0 && nums[pre]>current){
                nums[pre+1]=nums[pre];
                pre--;
            }
            nums[pre+1] = current;
        }
        for (int i=1;i<length;i++){
            if (nums[i]<=nums[i-1]){
                count += nums[i-1]-nums[i]+1;
                nums[i] = nums[i-1]+1;
            }
        }
        return count;
    }
}

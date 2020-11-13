package aa;

import java.util.Arrays;

public class test65 {
    public static void main(String[] args) {
        int[] nums = {1};
        nextPermutation(nums);
        for (int n : nums)
            System.out.print(n+" ");
    }
    public static void nextPermutation(int[] nums){
        int len = nums.length;
        for (int i=len-2; i>=0; i--){
            int min = -1;
            for (int j=i+1; j<len; j++){
                if (nums[j]>nums[i] && (min==-1 || nums[j]<nums[min])){
                    min = j;
                }
            }
            if (min!=-1){
                nums[i] = nums[i]+nums[min]-(nums[min]=nums[i]);
                int[] ch = new int[len-i-1];
                for (int j=i+1; j<len; j++){
                    ch[j-i-1] = nums[j];
                }
                Arrays.sort(ch);
                for (int j=i+1; j<len; j++){
                    nums[j] = ch[j-i-1];
                }
                return;
            }
        }
        int left = 0, right = len-1;
        while (left < right){
            nums[left] = nums[left]+nums[right]-(nums[right]=nums[left]);
            left++;
            right--;
        }
        return;
    }
}

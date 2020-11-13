package aa;

public class test39 {
    public static void main(String[] args) {
        int[] num = {0};
        sortColors(num);
        for (int n : num)
            System.out.print(n+" ");
    }
    public static void sortColors(int[] nums){
        int left = 0;
        while (left<nums.length && nums[left]==0)
            left++;
        int right = nums.length-1;
        while (right>=0 && nums[right]==2)
            right--;
        int i = left;
        while (i <= right){
            if (nums[i]==2){
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }
            else if (nums[i]==0){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            }else
                i++;
        }
    }
}

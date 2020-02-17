package LeetCode;

public class Medium_SortColors {
    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
        for (int a: nums)
            System.out.print(a+" ");
    }
    public static void sortColors(int[] nums){
        int[] arr = new int[nums.length];
        int start = 0, end = nums.length-1;
        for (int num : nums){
            if (num == 0){
                arr[start]=0;
                start++;
            }
            if (num==2){
                arr[end]=2;
                end--;
            }
        }
        while (start<=end){
            arr[start]=1;
            start++;
        }
        for (int a: arr)
            System.out.print(a+" ");
        nums = arr.clone();
    }
    public static void sortColors2(int[] nums){
        int start = 0, end = nums.length-1;
        for (int a: nums){
            if (a==0)
                start++;
            if (a==2)
                end--;
        }
        for (int i=0;i<start;i++)
            nums[i]=0;
        for (int i=start;i<=end;i++)
            nums[i]=1;
        for (int i=end+1;i<nums.length;i++)
            nums[i]=2;
    }
}

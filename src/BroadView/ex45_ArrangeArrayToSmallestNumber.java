package BroadView;

public class ex45_ArrangeArrayToSmallestNumber {
    public static void main(String[] args){
        int[] nums = {10,2};
        int[] nums2 = {3,30,34,5,9};
        ex45_ArrangeArrayToSmallestNumber ex = new ex45_ArrangeArrayToSmallestNumber();
        System.out.println(ex.minNumber(nums2));
    }
    public String minNumber(int[] nums){
//        for (int i=0;i<nums.length;i++){
//            for (int j=i;j<nums.length;j++){
//                if (compare(nums[i], nums[j])){
//                    int a = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = a;
//                }
//            }
//        }
        quickSort(nums, 0, nums.length-1);
        String str = "";
        for (int a: nums)
            str += a;
        return str;
    }
    //使用快排
    public void quickSort(int[] nums, int left, int right){
        if (left>right)
            return;
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid-1);
        quickSort(nums, mid+1, right);
    }
    public int partition(int[] nums, int left, int right){
        int key = nums[left];
        while (left<right){
            while (compare(nums[right], key) && left<right)
                right--;
            nums[left] = nums[right];
            while (!compare(nums[left], key) && left<right)
                left++;
            nums[right] = nums[left];
        }
        nums[right] = key;
        return right;
    }
    //false代表a<b
    public boolean compare(int a, int b){
        String strab = a+""+b;
        String strba = b+""+a;
        for (int i=0;i<strab.length();i++){
            if (strab.charAt(i)-strba.charAt(i)<0)
                return false;
            if (strab.charAt(i)-strba.charAt(i)>0)
                return true;
        }
        return false;
    }
}

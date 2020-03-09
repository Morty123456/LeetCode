package BroadView;

public class ex56_singleNumbers {
    public static void main(String[] args){
//        int[] nums = {4,1,4,6};
        int[] nums = {1,2,10,4,1,4,3,3};
        System.out.println((2&2)+" "+(3&2)+" "+(5&2));
        singleNumber(nums);
    }
    public static int[] singleNumber(int[] nums){
        int resulrXOR = 0;
        for (int num : nums)
            resulrXOR ^= num;
        int findLocal = 1;
//        int local = 1;
//        System.out.println(resulrXOR);
//        System.out.println(findLocal^resulrXOR);
        while((findLocal&resulrXOR)==0){
            findLocal = findLocal<<1;
//            local++;
        }
//        System.out.println(local);
        int left=0, right=nums.length-1;
        while (left<right){
            while ((nums[left]&findLocal)==0 && left<right)
                left++;
            while ((nums[right]&findLocal)!=0 && left<right)
                right--;
            if (left<right){
                int a = nums[left];
                nums[left] = nums[right];
                nums[right] = a;
            }
        }
        int[] res = new int[2];
        int resLeftXOR=0, resRightXOR=0;
        int mid=0;
        if ((nums[left]&findLocal)!=0)
            left--;
        for (int i=0;i<=left;i++)
            resLeftXOR ^= nums[i];
        for (int i=left+1;i<nums.length;i++)
            resRightXOR ^= nums[i];
        res[0] = resLeftXOR;
        res[1] = resRightXOR;
//        System.out.println(resLeftXOR+" "+resRightXOR);
        return res;
    }
}

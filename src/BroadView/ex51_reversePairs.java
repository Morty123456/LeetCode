package BroadView;

public class ex51_reversePairs {
    public static void main(String[] args){
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }
    //答案，归并排序
    public static int reversePairs(int[] nums){
        int len = nums.length;
        if (len<2)
            return 0;
        int[] tmp = new int[len];
        return reversePairs(nums, 0, len-1, tmp);
    }
    //一边归并排序，一边比较
    public static int reversePairs(int[] nums, int left, int right, int[] tmp){
        if (left==right)
            return 0;
        int mid = (left+right)/2;
        int leftreversePairs = reversePairs(nums, left, mid, tmp);
        int rightreversePairs = reversePairs(nums, mid+1, right, tmp);
        int reversePairs = leftreversePairs+rightreversePairs;
        if (nums[mid]<=nums[mid+1])
            return reversePairs;
        int reverseCrossPairs = mergeAndCount(nums, left, mid, right, tmp);
        return reversePairs+reverseCrossPairs;
    }
    //left到mid，mid+1到right都是有序的
    //现在要计算左边和右边的倒序
    //并且进行排序
    public static int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp){
        for (int i=left;i<=right;i++)
            tmp[i] = nums[i];
        int i = left;
        int j = mid+1;
        int res = 0;
        for (int k=left;k<=right;k++){
            if (i>mid){
                nums[k] = tmp[j];
                j++;
            }
            else if(j>right){
                nums[k] = tmp[i];
                i++;
            }
            else if (tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i++;
            }
            else {
                nums[k] = tmp[j];
                j++;
                res += (mid-i+1);
            }
        }
        return res;
    }
    //暴力
    public static int reversePairs2(int[] nums){
        int length = nums.length;
        int count = 0;
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if (nums[i]>nums[j])
                    count++;
            }
        }
        return count;
    }
}

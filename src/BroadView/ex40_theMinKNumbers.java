package BroadView;

public class ex40_theMinKNumbers {
    public static void main(String[] args){
        int[] arr = {0,1,1,2,4,4,1,3,3,2};
        int k = 6;
        int[] num = getLeastNumbers(arr, k);
        for (int n:num)
            System.out.println(n);
    }

    public static int[] getLeastNumbers(int[] arr, int k){
        if (k==0)
            return new int[0];
        if (arr.length==k)
            return arr;
        int[] num = new int[k];
        for (int i=0;i<k;i++)
            num[i] = arr[i];
        heapSort(num);
        for (int i=k;i<arr.length;i++){
            if (arr[i]<num[0]){
                num[0]=arr[i];
                adjustHeap(num, 0);
            }
        }
        return num;
    }
    public static void heapSort(int[] nums){
        int i=nums.length/2-1;
        while (i>=0)
            adjustHeap(nums, i--);
    }
    public static void adjustHeap(int[] nums, int i){
        int temp = nums[i];
        int len = nums.length;
        for (int k=i<<1+1; k<len; k=k<<1+1){
            if (k+1<len && nums[k+1]>nums[k])
                k++;
            if (nums[k]>temp){
                nums[i]=nums[k];
                i=k;
            }
            else
                break;
        }
        nums[i] = temp;
    }
    public static void swap(int[] nums, int i, int j){
        nums[i] = nums[i]+nums[j]-(nums[j]=nums[i]);
    }
}

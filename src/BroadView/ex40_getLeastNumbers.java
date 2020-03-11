package BroadView;

public class ex40_getLeastNumbers {
    public static void main(String[] args){
        int[] num = {3,2,1};
        int[] res = new int[2];
        res = getLeastNumbers(num, 2);
        for (int a : res)
            System.out.println(a);
    }
    public static int[] getLeastNumbers(int[] arr, int k){
        if (k==0)
            return new int[0];
        int len = arr.length;
        if (k==len)
            return arr;
        int[] heap = new int[k];
        for (int i=0;i<k;i++)
            heap[i] = arr[i];
        buildHeap(heap);
        for (int i=k;i<len;i++){
            if (arr[i]<heap[0]){
                heap[0] = arr[i];
                help(heap, 0);
            }
        }
        return heap;
    }
    public static void buildHeap(int[] nums){
        int lastNode = nums.length-1;
        int startNode = (lastNode-1)/2;
        while (startNode>=0)
            help(nums, startNode--);
    }
    public static void help(int[] num, int i){
        int len = num.length;
        if (i >= len)
            return;
        int left = ((i<<1)+1), right = ((i<<1)+2);
        int max = i;
        if (left<len && num[left]>num[max])
            max = left;
        if (right<len && num[right]>num[max])
            max = right;
        if (max!=i){
            swap(num, i, max);
            help(num, max);
        }
    }
    public static void swap(int[] nums, int i, int j){
        nums[i] = nums[i]+nums[j] - (nums[j]=nums[i]);
    }
}

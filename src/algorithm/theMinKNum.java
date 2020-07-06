package algorithm;

/**
 * @author: wzh
 * @time: 2020/7/6 21:23
 * @description:
 */
public class theMinKNum {
    public static void main(String[] args){
        int[] nums = {3,5,2,7,9,1,6,8,4};
        heapSort(nums);
    }
    public static void heapSort(int[] nums){
        int[] arr = new int[5];
        for (int i=0;i<5;i++){
            arr[i] = nums[i];
        }
        //找到最小的K个数，构建大顶堆
        //构建初始堆
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }
        //把小的放右下角
//        for (int i=arr.length-1;i>0;i--){
//            swap(arr, 0, i);
//            adjustHeap(arr, 0, i);
//        }
        //加入新的数字
        for (int i=5;i<9;i++){
            if (nums[i]<arr[0]){
                arr[0] = nums[i];
                adjustHeap(arr, 0, arr.length);
            }
        }
        for (int a : arr)
            System.out.println(a+" ");
    }
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for (int k=2*i+1;k<length;k=2*k+1){
            if (k+1<length && arr[k+1]>arr[k])
                k++;
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }
        }
        arr[i]=temp;
    }
    public static void swap(int[] arr, int a, int b){
        arr[a] = (arr[a]+arr[b])-(arr[b]=arr[a]);
    }
}

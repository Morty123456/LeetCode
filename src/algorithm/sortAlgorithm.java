package algorithm;

//排序算法
//比较排序：交换排序：冒泡排序，快速排序
//          插入排序：简单插入排序，希尔排序
//          选择排序：简单选择排序，堆排序
//          归并排序：二路归并排序，多路归并排序
//非比较：  计数排序
//          桶排序
//          基数排序
public class sortAlgorithm {
    public static void main(String[] args){
        int[] arr = {2,4,6,1,5,8,9,3,7};
        sortAlgorithm sort = new sortAlgorithm();
//        sort.bubbleSort(arr);
//        sort.selectionSort(arr);
//        sort.insertionSort(arr);
//        sort.shellSort(arr);
//        sort.mergeSort(arr);
//        sort.quickSort(arr);
        sort.heapSort(arr);
        for (int a: arr)
            System.out.print(a+" ");
    }
//  冒泡排序
    public void bubbleSort(int[] arr){
        int length = arr.length;
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if(arr[i]>arr[j]){
                    int tar = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tar;
                }
            }
        }
    }
//  选择排序
    public void selectionSort(int[] arr){
        int length = arr.length;
        for (int i=0;i<length;i++){
            int min=i;
            for (int j=i+1;j<length;j++)
                min = arr[j]<arr[min] ? j:min;
            if(arr[min]<arr[i]){
                int tar = arr[i];
                arr[i]=arr[min];
                arr[min]=tar;
            }
        }
    }
//  插入排序
    public void insertionSort(int[] arr){
        int length = arr.length;
        for (int i=1;i<length;i++){
            int pre = i-1;
            int current = arr[i];
            while (pre>=0 && arr[pre]>current){
                arr[pre+1]=arr[pre];
                pre--;
            }
            arr[pre+1]=current;
        }
    }
//  希尔排序
    public void shellSort(int[] arr){
        int length = arr.length;
        for (int gap=length/2;gap>0;gap/=2){
            for (int i=gap;i<length;i++){
                insert(arr,gap,i);
            }
        }
    }
    public void insert(int[] arr, int gap, int i){
        int insert = arr[i];
        int j;
        for (j=i-gap;j>=0&&insert<arr[j];j-=gap){
            arr[j+gap]=arr[j];
        }
        arr[j+gap]=insert;
    }
//  归并排序
    public void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }
    public void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    public void merge(int[] arr,int left, int mid, int right, int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j])
                temp[t++]=arr[i++];
            else
                temp[t++]=arr[j++];
        }
        while (i<=mid)
            temp[t++]=arr[i++];
        while (j<=right)
            temp[t++]=arr[j++];
        t=0;
        while(left<=right)
            arr[left++]=temp[t++];
    }
//  快速排序
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    public void quickSort(int[] arr,int left, int right){
        if (left>right)
            return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index-1);
        quickSort(arr, index+1, right);
    }
    public int partition(int[] a, int left, int right){
        int key = a[left];
        while (left<right){
            while (a[right]>=key && left<right)
                right--;
            a[left]=a[right];
            while (a[left]<=key && left<right)
                left++;
            a[right]=a[left];
        }
        a[right]=key;
        return right;
    }
//  堆排序
    public void heapSort(int[] arr){
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }
        for (int j=arr.length-1;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }
    public void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for (int k=i*2+1;k<length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1])
                k++;
            if (arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }
            else
                break;
        }
        arr[i] = temp;
    }
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

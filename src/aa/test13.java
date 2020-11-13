package aa;

public class test13 {
    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1};
        solution(num);
        for (int n : num)
            System.out.println(n+" ");
    }
    public static void solution(int[] num){
        int[] temp = new int[num.length];
        mergeSort(num, 0, num.length-1, temp);
    }
    public static void mergeSort(int[] num, int left, int right, int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(num, left, mid, temp);
            mergeSort(num, mid+1, right, temp);
            merge(num, left, mid, right, temp);
        }
    }
    public static void merge(int[] num, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right){
            if (num[i]<=num[j]){
                temp[t++] = num[i];
                i++;
            }else{
                temp[t++] = num[j];
                j++;
            }
        }
        while (i<=mid){
            temp[t++] = num[i++];
        }
        while (j<=right){
            temp[t++] = num[j++];
        }
        t = 0;
        for(int k=left; k<=right; k++){
            num[k] = temp[t++];
        }
    }
}

package aa;

public class test17 {
    public static void main(String[] args) {
        int[] num = {3,6,1,5,7,9,4,8};
        merge(num, 0, num.length-1);
        for (int n:num)
            System.out.print(n+" ");
    }
    public static void merge(int[] num, int left, int right){
        if (left<right){
            int mid = (left+right)/2;
            merge(num, left, mid);
            merge(num, mid+1, right);
            merge(num, left, mid, right);
        }
    }
    public static void merge(int[] num, int left, int mid, int right){
        int l = left;
        int r = mid+1;
        int t = 0;
        int[] temp = new int[right-left+1];
        while (l<=mid && r<=right){
            if (num[l] < num[r]){
                temp[t] = num[l];
                l++;
            }else{
                temp[t] = num[r];
                r++;
            }
            t++;
        }
        while (l<=mid){
            temp[t++] = num[l++];
        }
        while (r<=right){
            temp[t++] = num[r++];
        }
        t = 0;
        while (left<=right){
            num[left++] = temp[t++];
        }
    }
}

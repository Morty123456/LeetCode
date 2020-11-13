package aa;

public class test20 {
    public static void main(String[] args) {
        int[] num = {1,3};
        int target = 3;
        System.out.println(solution(num, target));
    }
    public static int solution(int[] a, int target){
        int left = 0;
        int right = a.length-1;
        while(left < right){
            int mid = (left+right)/2;
            if (a[mid]<a[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        int l = find(a, 0, left, target);
        if (l!=-1)
            return l;
        int r = find(a, left, a.length-1, target);
        if (r!=-1)
            return r;
        return -1;
    }
    public static int find(int[] a, int left, int right, int target){
        while (left<=right){
            int mid = (left+right)/2;
            if (a[mid]==target){
                return mid;
            }
            if(a[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}

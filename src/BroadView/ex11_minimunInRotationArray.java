package BroadView;

public class ex11_minimunInRotationArray {
    public static void main(String[] args){
        int[] nums =  {2,2,2,0,1};
        System.out.println(minArray2(nums));
    }
    public static int minArray2(int[] numbers){
        int length = numbers.length;
        int left=0, right=length-1;
        if (length==0)
            return 0;
        while (left<right){
            int mid=(left+right)/2;
            if (numbers[mid]>numbers[right])
                left=mid+1;
            else if(numbers[mid]==numbers[right])
                right--;
            else
                right=mid;
        }
        return numbers[left];
    }
    public static int minArray(int[] numbers){
        int begin = 0, end = numbers.length-1;
        int mid = 0;
        if (begin==end)
            return numbers[begin];
        if (numbers[begin] < numbers[end])
            return numbers[mid];
        while (numbers[begin]>=numbers[end]){
            if (end-begin==1)
                return numbers[end];
            mid = (begin+end)/2;
            if (numbers[mid]==numbers[begin] && numbers[mid]==numbers[end]){
                for (int i=begin+1;i<=end;i++)
                    if (numbers[i]<numbers[i-1])
                        return numbers[i];
            }
            if (numbers[mid]>=numbers[begin])
                begin = mid;
            else
                end = mid;
        }
        return 0;
    }
}

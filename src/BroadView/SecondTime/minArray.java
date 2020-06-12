package BroadView.SecondTime;

public class minArray {
    public static void main(String[] args){
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }
    public static int minArray(int[] numbers){
        int left = 0, right = numbers.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (numbers[mid]>numbers[right])
                left = mid+1;
            else if (numbers[mid]<numbers[right])
                right = mid;
            else
                right--;
        }
        return numbers[right];
    }
}

package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/7/13 6:21
 * @description:
 */
public class ex_53_search {
    public static void main(String[] args){
        int[] num = {6};
        int target = 6;
        System.out.println(search(num, target));
    }
    public static int search(int[] nums, int target){
        int length = nums.length;
        int left = 0, right = length-1;
        int local = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]<target)
                left=mid+1;
            else if (nums[mid]>target)
                right=mid-1;
            else {
                local = mid;
                break;
            }
        }
        if (local==-1)
            return 0;
        int count = 0;
        int local2 = local;
        while (local<length && nums[local]==target){
            count++;
            local++;
        }while (local2>=0 && nums[local2]==target){
            count++;
            local2--;
        }
        return count-1;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Medium_numberOfSubarrays {
    public static void main(String[] args){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<length;i++)
            if (nums[i]%2==1)
                list.add(i);
        int sum = 0;
        if (list.size()<k)
            return 0;
        for (int i=0;i<=list.size()-k;i++){
            int begin = 0, end = length-1;
            if (i>0)
                begin = list.get(i-1)+1;
            if (i+k<list.size())
                end = list.get(i+k)-1;
            sum += (list.get(i)-begin+1)*(end-list.get(i+k-1)+1);
        }
        return sum;
    }
    //官方题解
    public static int numberOfSubarrays2(int[] nums, int k){
        int length = nums.length;
        int[] odd = new int[length+2];
        int ans = 0, cnt = 0;
        for (int i=0;i<length;i++){
            if (nums[i]%2==1)
                odd[++cnt]=i;
        }
        odd[0] = -1;
        odd[++cnt]=length;
        for (int i=1;i+k<=cnt;i++)
            ans += (odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]);
        return ans;
    }
}

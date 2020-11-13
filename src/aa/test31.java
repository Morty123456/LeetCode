package aa;

import java.util.ArrayList;

public class test31 {
    public static void main(String[] args) {
        int[] num = {3,5,11,12};
        Integer[] nums = new Integer[num.length];
        for (int i=0; i<num.length; i++){
            nums[i] = Integer.valueOf(num[i]);
        }
        Integer[] res = find_prime(nums);
        for (Integer r : res)
            System.out.println(r);
    }
    public static Integer[] find_prime(Integer[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums){
            if (judge(num)){
                list.add(num);
            }
        }
        Integer[] res = new Integer[list.size()];
        for (int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static boolean judge(Integer num){
        int n = num.intValue();
        for (int i=2; i<=n/2; i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}

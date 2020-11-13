package aa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test53 {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] res = solution(nums);
        for (int r : res)
            System.out.print(r+" ");
    }
    public static int[] solution(int[] num){
        int[] sortNum = new int[num.length];
        for (int i=0; i<sortNum.length; i++)
            sortNum[i] = num[i];
        Arrays.sort(sortNum);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<sortNum.length; i++){
            if (!hashMap.containsKey(sortNum[i]))
                hashMap.put(sortNum[i], i);
        }
        int[] res = new int[sortNum.length];
        for (int i=0; i<res.length; i++){
            res[i] = hashMap.get(num[i]);
        }
        return res;
    }
}

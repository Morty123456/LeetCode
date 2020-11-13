package aa;

import java.util.*;

public class test60 {
    public static void main(String[] args) {
        int[] num = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(num);
        for (int a : res)
            System.out.print(a+" ");
    }
    public static int[] sortByBits(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : arr){
            list.add(a);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int e1 = getNumOfOne(o1);
                int e2 = getNumOfOne(o2);
                if (e1 == e2){
                    return o1 - o2;
                }else {
                    return e1 - e2;
                }
            }
        });
        int[] res = new int[arr.length];
        for (int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static int getNumOfOne(int num){
        int count = 0;
        while (num>0){
            count += num&1;
            num >>= 1;
        }
        return count;
    }
}

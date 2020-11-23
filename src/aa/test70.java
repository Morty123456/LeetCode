package aa;

import java.util.Arrays;

public class test70 {
    public static void main(String[] args) {
        int[] res1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] res2 = {2,1,4,3,9,6};
        int[] res = relativeSortArray(res1, res2);
        for (int n : res){
            System.out.print(n+" ");
        }
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        int len = arr1.length;
        int[] res = new int[len];
        boolean[] isIn = new boolean[len];
        int resLeft = 0;
        int count = 0;
        for (int n : arr2){
            for (int i=0; i<len; i++){
                if (arr1[i]==n){
                    res[resLeft] = n;
                    resLeft++;
                    isIn[i] = true;
                    count++;
                }
            }
        }
        int[] add = new int[len-count];
        int addLeft = 0;
        for (int i=0; i<len; i++){
            if (!isIn[i]){
                add[addLeft] = arr1[i];
                addLeft++;
            }
        }
        Arrays.sort(add);
        for (int i=count; i<len; i++){
            res[i] = add[i-count];
        }
        return res;
    }
}

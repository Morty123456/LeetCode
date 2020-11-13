package aa;

import java.util.ArrayList;
import java.util.Arrays;

public class test28 {
    public static void main(String[] args) {
        int[] num = {100,10,20,70,60,10,50};
        int target = 80;
        com(num, target);
        for (ArrayList<Integer> l : lists){
            for (int n : l)
                System.out.print(n+" ");
            System.out.println();
        }
    }
    static ArrayList<ArrayList<Integer>> lists;
    static ArrayList<Integer> path;
    public static ArrayList<ArrayList<Integer>> com(int[] num, int target){
        Arrays.sort(num);
        lists = new ArrayList<>();
        path = new ArrayList<>();
        track(num, target, 0);
        return lists;
    }
    public static void track(int[] num, int target, int start){
        if (target==0){
            lists.add(new ArrayList<>(path));
            return;
        }
        if (target<0)
            return;
        for (int i=start; i<num.length; i++){
            if (i>start && num[i]==num[i-1])
                continue;
            path.add(num[i]);
            track(num, target-num[i], i+1);
            path.remove(path.size()-1);
        }
    }
}

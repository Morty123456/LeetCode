package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Medium_merge {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,3},{0,3}};

        int[][] res = merge(intervals);
        for (int[] re : res){
            for (int r : re)
                System.out.print(r+" ");
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals){
        Arrays.parallelSort(intervals, Comparator.comparingInt(x->x[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] re : intervals){
            if (list.isEmpty() || list.getLast()[1]<re[0]){
                list.add(re);
            }
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], re[1]);
            }
        }
        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }
}

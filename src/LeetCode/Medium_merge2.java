package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: wzh
 * @time: 2020/9/11 19:12
 * @description:
 */
public class Medium_merge2 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int[] r : res){
            System.out.println(r[0]+" "+r[1]);
        }
    }
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for (int i=1; i<intervals.length; i++){
            int[] last = resList.get(resList.size()-1);
            if (last[1] >= intervals[i][0]){
                last[1] = Math.max(last[1], intervals[i][1]);
                resList.remove(resList.size()-1);
                resList.add(last);
            }else{
                resList.add(intervals[i]);
            }
        }
        int[][] res = new int[resList.size()][2];
        for (int i=0; i< res.length; i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}

package aa;

import java.util.LinkedList;

public class test58 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] res = insert(intervals, newInterval);
        for (int[] a : res){
            System.out.println(a[0] +" "+ a[1]);
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> resList = new LinkedList<>();
        int left = 0;
        int len = intervals.length;
        while (left < len && intervals[left][1] < newInterval[0]){
            resList.add(intervals[left]);
            left++;
        }
        while (left < len && intervals[left][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[left][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[left][1], newInterval[1]);
            left++;
        }
        resList.add(newInterval);
        while (left < len){
            resList.add(intervals[left]);
            left++;
        }
        int[][] resArr = new int[resList.size()][2];
        int i = 0;
        for (int [] a : resList){
            resArr[i] = a;
            i++;
        }
        return resArr;
    }
}

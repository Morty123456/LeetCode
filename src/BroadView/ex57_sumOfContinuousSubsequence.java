package BroadView;

import java.util.ArrayList;
import java.util.List;

public class ex57_sumOfContinuousSubsequence {
    public static void main(String[] args){
        int[][] out = findContinuousSequence(15);
        for (int[] a : out){
            for (int aa: a)
                System.out.print(aa+" ");
            System.out.println();
        }
    }
    public static int[][] findContinuousSequence(int target) {
        int begin = 1, end = 2;
        int sum = 3;
        List<int[]> list = new ArrayList<>();
        while (end <= target / 2 + 1 && begin <= end) {
            if (sum < target) {
                end++;
                sum += end;
            } else if (sum > target) {
                sum -= begin;
                begin++;
            } else {
                int[] num = new int[end - begin+1];
                for (int i = begin; i <= end; i++)
                    num[i - begin] = i;
                sum -= begin;
                begin++;
                list.add(num);
            }
        }
        int[][] out = new int[list.size()][];
        return list.toArray(out);
    }
}

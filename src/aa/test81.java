package aa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class test81 {
    public static void main(String[] args) {
//        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length==0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]<o2[1]?-1:1;
            }
        });
        int count = 1;
        int right = points[0][1];
        for (int i=1; i<points.length; i++){
            if (right < points[i][0]){
                count++;
                right= points[i][1];
            }
        }
        return count;
    }
}

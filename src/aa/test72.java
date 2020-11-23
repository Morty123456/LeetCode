package aa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class test72 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        people = reconstructQueue(people);
        for (int[] num : people){
            System.out.println(num[0]+" "+num[1]);
        }
    }
    public static int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, ((o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] num : people){
            res.add(num[1], num);
        }
        return res.toArray(people);
    }
}

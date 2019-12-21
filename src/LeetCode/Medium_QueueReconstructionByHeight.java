package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * 每个人都是用一对整数（h，k）来描述的
 * 其中h是人的身高，k是这个人前面身高大于或等于h的人数
 * 编写一个算法来重建队列。
 * @author: wzh
 * @create: 2019-12-21 22:03
 **/
public class Medium_QueueReconstructionByHeight {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] people = new int[n][2];
        for (int i=0;i<n;i++){
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }
        people = reconstructQueue(people);
    }
    public static int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int[] a = o1;
                int[] b = o2;
                if (a[0]<b[0])
                    return 1;
                else if (a[0]==b[0]){
                    if (a[1]<b[1])
                        return -1;
                    else
                        return 1;
                }
                else
                    return -1;
            }
        });
        for (int[] a: people)
            System.out.println(a[0] +" "+ a[1]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int i=0;i<people.length;i++){
            
        }
        return people;
    }
}

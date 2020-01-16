package LeetCode;

import java.util.*;

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
        for (int[] a: people)
            System.out.println(a[0]+" "+a[1]);
    }
    //先按照高矮排序，高的站在前面
    //在按着第二位排序，小的站在前面
    //然后用list里面的add函数，把该人放到要在的地方
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
<<<<<<< HEAD
        for (int[] a: people)
            System.out.println(a[0] +" "+ a[1]);
        LinkedList<int[]> list = new LinkedList<>();

        for (int i=0;i<people.length;i++){
            
=======
        List<int[]> list = new ArrayList<>();
        for (int[] a: people){
            list.add(a[1], a);
>>>>>>> 523c0de41d7bf510027d402fd8512965de61ed0f
        }
        int[][] sort = new int[list.size()][2];
        for (int i=0;i<list.size();i++)
            sort[i] = list.get(i);
        return sort;
    }
}

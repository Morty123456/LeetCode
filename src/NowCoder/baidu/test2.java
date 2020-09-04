package NowCoder.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/3 19:38
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] list = new ArrayList[m];
            for (int j = 0; j < m; j++) {
                int count = sc.nextInt();
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int k = 0; k < count; k++) {
                    int begin = sc.nextInt();
                    int end = sc.nextInt();
                    arrayList.add(begin);
                    arrayList.add(end);
                }
                list[j] = arrayList;
            }
            solution(n, list);
        }
    }
    public static void  solution(int n, ArrayList[] arrayLists){
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            int count = 0;
            for (int j = 0; j < arrayLists.length; j++) {
                if (!inNum(i, arrayLists[j])){
                    break;
                }
                count++;
            }
            if (count==arrayLists.length)
                list.add(i);
        }
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static boolean inNum(int i, ArrayList<Integer> list){
        for (int j = 0; j < list.size(); j+=2) {
            if (list.get(j)<=i && list.get(j+1)>=i)
                return true;
        }
        return false;
    }
//    public static List<Integer> solution(ArrayList[] arrayLists, int n){
//        int len = arrayLists.length;
//        List<Integer> list = new LinkedList<>();
//        int[] local = new int[len];
//        for (int i = 1; i <=n ; i++) {
//            //第i头奶牛是否符合全部j个标准
//            for (int j = 0; j < len; j++) {
//                int lo = local[i];
//                //找到 数组后面 大于此奶牛号的
//                while (lo< arrayLists[j].size() && (int)arrayLists[j].get(lo+1) < i){
//                    lo += 2;
//                }
//                //如果前面也大于此奶牛号，则以后都不会符合，直接返回
//                if ((int)arrayLists[j].get(lo)>i)
//                    return list;
//                local[i] = lo;
//            }
//        }
//    }
}

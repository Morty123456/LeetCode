package aa;

import java.util.*;

public class test43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new LinkedList<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            if (str.equals("#"))
                break;
            String[] strs = str.split(" ");
            int[] num = {Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
            list.add(num);
        }
        System.out.println(solution(list));
    }
    public static int solution(List<int[]> list){
        List<int[]> a = new LinkedList<>();
        List<int[]> b = new LinkedList<>();
        for (int[] num : list){
            if (num[0]>num[1])
                a.add(num);
            else
                b.add(num);
        }
        int n = list.size()/2;
        int[] res = {0,0};
        if (a.size()>n){
            Collections.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]+o1[1] - o2[0]-o2[1];
                }
            });
            for (int i=0; i<a.size()-n; i++){
                b.add(a.get(i));
                a.set(i, res);
            }
        }
        if (b.size()>n){
            Collections.sort(b, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]+o1[1] - o2[0]-o2[1];
                }
            });
            for (int i=0; i<b.size()-n; i++){
                a.add(b.get(i));
                b.set(i, res);
            }
        }
        int sum = 0;
        for (int[] num : a){
            sum += num[0];
        }
        for (int[] num : b){
            sum += num[1];
        }
        return sum;
    }
}

package aa;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class test37 {
    public static void main(String[] args){
        int[] num = {30,1};
        System.out.println(solve(num));
    }
    public static String solve(int[] nums){
        List<Integer> list = new LinkedList<>();
        for (int num : nums){
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1= o1+""+o2;
                String s2 = o2+""+o1;
                return Integer.parseInt(s2) - Integer.parseInt(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer num : list){
            sb.append(num);
        }
        return sb.toString();
    }
}

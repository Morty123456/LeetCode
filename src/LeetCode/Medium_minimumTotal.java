package LeetCode;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/7/14 9:15
 * @description:
 */
public class Medium_minimumTotal {
    public static void main(String[] args){
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);lists.add(list1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);list2.add(4);
        lists.add(list2);
        List<Integer> list3 = new LinkedList<>();
        list3.add(6);list3.add(5);list3.add(7);
        lists.add(list3);
        List<Integer> list4 = new LinkedList<>();
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        lists.add(list4);
        System.out.println(minimumTotal(lists));
    }
    public static int minimumTotal(List<List<Integer>> triangle){
        int length = triangle.size();
        for (int i=length-2;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                int num = triangle.get(i).get(j);
                num += Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, num);
            }
        }
        return triangle.get(0).get(0);
    }
}

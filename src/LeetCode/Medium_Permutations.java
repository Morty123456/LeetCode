package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * program: LeetCode
 * description: 寻找数组的所有排序结果
 * Author: wzh
 * create: 2020-01-31 15:55
 */
public class Medium_Permutations {
    public static void main(String[] args){
        int[] nums = {1,2,3};
//        List<List<Integer>> list = permute(nums);
//        for (List arrList : list){
//            System.out.println(arrList.toString());
//        }

        //List list = new ArrayList<>(test)，为test的深拷贝，修改list不会影响test
        List<Integer> test = new ArrayList<>();
        test.add(1);
        List<Integer> test1 = new ArrayList<>(test);
        test1.add(2);
        System.out.println(test.toString());
        List<Integer> test2 = new ArrayList<>();
        test2 = test;
        test2.add(2);
        System.out.println(test2.toString());
    }
    public static List<List<Integer>> permute(int[] nums){
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> beginList = new ArrayList<>();
        beginList.add(nums[0]);
        list.add(beginList);
        for (int i=1;i<length;i++){
            List<List<Integer>> list1 = new ArrayList<>();
            for (List arrList : list){
                int len = arrList.size();
                for (int j=0;j<=len;j++){
                    List<Integer> addList = new ArrayList<>(arrList);
                    addList.add(j, nums[i]);
                    list1.add(addList);
                }
            }
            list = list1;
        }
        return list;
    }
}
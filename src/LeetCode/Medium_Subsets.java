package LeetCode;

import sun.plugin2.message.MouseEventMessage;
import sun.text.CollatorUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 寻找数组子集
 * @author: wzh
 * @create: 2020-01-15 09:07
 **/
public class Medium_Subsets {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> member : result){
            System.out.println(member.toString());
        }
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        result.add(path);
        for (int i=0;i<nums.length;i++){
            int length = result.size();
            for (int j=0;j<length;j++){
                List<Integer> member = result.get(j);
//                System.out.println(member.toString());
                List<Integer> copy = new ArrayList<>();
                for (int a : member)
                    copy.add(a);
                copy.add(nums[i]);
//                System.out.println(copy.toString());
                result.add(copy);
//                System.out.println(result.toString());
            }
            //使用循环遍历时，内容不允许修改
//            for (List<Integer> member : result){
//                System.out.println(member.toString()+"  "+nums[i]);
//                List<Integer> copy = new ArrayList<>();
//                for (int user : member)
//                    copy.add(user);
//                copy.add(nums[i]);
//                System.out.println(copy.toString());
//                result.add(copy);
//                System.out.println(result.toString());
//            }

            //使用迭代器遍历

//            for (Iterator<List<Integer>> member = result.iterator();member.hasNext();){
//                List<Integer> memList = member.next();
////                member.remove();
//                System.out.println(memList.toString());
//                List<Integer> copy = new ArrayList<>();
//                for (int mem : memList)
//                    copy.add(mem);
//                copy.add(nums[i]);
//                System.out.println(copy.toString());
//                result.add(copy);
//            }
        }
        return result;
    }
}

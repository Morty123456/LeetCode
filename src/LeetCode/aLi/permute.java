package LeetCode.aLi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/8 8:38
 * @description:
 */
public class permute {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list: lists){
            for (int i : list)
                System.out.print(i+" ");
            System.out.println();
//            Iterator<Integer> iterator = list.iterator();
//            while (iterator.hasNext())
//                System.out.print(iterator+" ");
//            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> lists = new LinkedList<>();
        if (len==0)
            return lists;
        boolean[] used = new boolean[len];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(lists, path, used, nums, len, 0);
        return lists;
    }
    public static void dfs(List<List<Integer>> lists, LinkedList<Integer> path, boolean[] used, int[] nums, int len, int depth){
        if (depth==len){
            lists.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<len;i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(lists, path,used, nums, len, depth+1);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}

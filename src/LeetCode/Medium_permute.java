package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Medium_permute {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> list = premute(nums);
        for (List li : list)
            System.out.println(li.toString());
    }
    public static List<List<Integer>> premute(int[] nums){
        List<List<Integer>> list = new LinkedList<>();
        int len = nums.length;
        if (len==0)
            return list;
        List<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, list);
        return list;
    }
    public static void dfs(int[] nums, int len, int depth, List<Integer> path,
                           boolean[] used, List<List<Integer>> res){
        if (depth==len){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<len;i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth+1, path, used, res);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}

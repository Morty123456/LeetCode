package LeetCode;

import com.sun.org.apache.bcel.internal.generic.INEG;

import javax.swing.*;
import java.util.*;

/**
 * @author: wzh
 * @time: 2020/8/12 10:15
 * @description:
 */
public class Medium_combinationSum2 {
    public static void main(String[] args) {
        int[] can = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = solution(can, 8);
        for (List list : lists){
            Iterator iterator = list.iterator();
            while (iterator.hasNext())
                System.out.print(iterator.next());
            System.out.println();
        }
    }
    public static List<List<Integer>> solution(int[] candidates, int target){
        List<List<Integer>> lists = new LinkedList<>();
        int sum = 0;
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int ca : candidates){
//            if (map.containsKey(ca)){
//                map.put(ca, map.get(ca)+1);
//            }else
//                map.put(ca, 1);
//        }
        Arrays.sort(candidates);
        dfs2(lists, res, candidates, target, sum, 0);
        return lists;
    }
    public static void dfs(List<List<Integer>> lists, List<Integer>  res, int[] candidates,
                           int target, int sum, int start, HashMap<Integer, Integer> map){
        if (sum==target){
//            List<Integer> l = new LinkedList<>(res);
//            if (!lists.contains(l))
                lists.add(new LinkedList<>(res));
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            if (sum>target)
                break;
            if (i>start && candidates[i]==candidates[i-1])
                continue;
//            if (map.get(candidates[i]) > 0){
                sum += candidates[i];
                res.add(candidates[i]);
//                map.put(candidates[i], map.get(candidates[i])-1);
                dfs(lists, res, candidates, target, sum, i+1, map);
//                map.put(candidates[i], map.get(candidates[i])+1);
                int num = res.remove(res.size() - 1);
                sum -= num;
//            }
        }
    }

    public static void dfs2(List<List<Integer>> lists, List<Integer>  res, int[] candidates,
                            int target, int sum, int start){
        if (sum==target){
            lists.add(new LinkedList<>(res));
        }
        for (int i=start;i<candidates.length;i++){
            if (sum+candidates[i] > target)
                break;
            if (i>start && candidates[i]==candidates[i-1])
                continue;
            sum += candidates[i];
            res.add(candidates[i]);
            dfs2(lists, res, candidates, target, sum, i+1);
            res.remove(res.size()-1);
            sum -= candidates[i];
        }
    }
}

package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/11 20:05
 * @description:
 */
public class Medium_combinationSum3 {
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 9);
        for (List<Integer> l : list){
            for (int i : l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
    static List<List<Integer>> list = new LinkedList<>();
    static List<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n){
        dfs(k, n, 1);
        return list;
    }
    public static void dfs(int k, int n, int start){
        if (path.size()==k && n==0){
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i=start; i<=9; i++){
            path.add(i);
            n -= i;
            dfs(k, n, i+1);
            n += i;
            path.remove(path.size()-1);
        }
    }
}

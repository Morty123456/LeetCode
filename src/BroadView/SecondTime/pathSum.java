package BroadView.SecondTime;

import java.util.LinkedList;
import java.util.List;

public class pathSum {
    public static void main(String[] args){

    }
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        path(root, sum);
        return res;
    }
    public static void path(TreeNode root, int tar){
        if (root==null)
            return;
        path.add(root.val);
        tar -= root.val;
        if (tar==0 && root.left==null && root.right==null)
            res.add(new LinkedList(path));
        path(root.left, tar);
        path(root.right, tar);
        path.pollLast();
    }
}

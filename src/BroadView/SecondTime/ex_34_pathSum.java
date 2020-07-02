package BroadView.SecondTime;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/7/2 17:11
 * @description:
 */
public class ex_34_pathSum {
    public static void main(String[] args){

    }
    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        recu(root, sum);
        return res;
    }
    public static void recu(TreeNode node, int sum){
        if (node==null)
            return;
        path.add(node.val);
        sum -= node.val;
        if (sum==0 && node.left==null && node.right==null){
            res.add(new LinkedList(path));
        }
        recu(node.left, sum);
        recu(node.right, sum);
        path.pollLast();
    }
}

package BroadView;

import java.util.LinkedList;
import java.util.List;

public class ex33_theSumOfaPathOfaBinaryTree {
    public static void main(String[] args){
        int[] nums = {5,4,8,11,0,13,4,7,2,0,0,5,1};
        TreeNode root = ex26_thrSubstructureOfaTree.makeTreeByNum(nums);
//        ex26_thrSubstructureOfaTree.Inorder(root);
        list = pathSum(root, 22);
        for (List<Integer> ali : list){
            for (int a : ali)
                System.out.print(a);
            System.out.println();
        }
    }
    static List<List<Integer>> list = new LinkedList<>();
    static List<Integer> path = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int Sum){
        if (root==null)
            return list;
        dfs(root, Sum);
        return list;
    }
    public static void dfs(TreeNode root, int sum){
        path.add(root.val);
        if (root.left==null && root.right==null){
            if (sum==root.val)
                list.add(new LinkedList<>(path));
            path.remove(path.size()-1);
            return;
        }
        if (root.left!=null)
            dfs(root.left, sum - root.val);
        if (root.right!=null)
            dfs(root.right, sum - root.val);
        path.remove(path.size()-1);
    }
}

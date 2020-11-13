package aa;

import java.util.ArrayList;

public class test27 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        ArrayList<ArrayList<Integer>> lists = pathSum(root, 1);
        int i = 0;
    }
    static ArrayList<ArrayList<Integer>> list;
    static ArrayList<Integer> path;
    public static ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        list = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, sum);
        return list;
    }
    public static void dfs(TreeNode node, int sum){
        if (node==null)
            return;
        if(sum==node.val && node.left==null && node.right==null){
            path.add(node.val);
            list.add(new ArrayList(path));
            return;
        }
        sum -= node.val;
        path.add(node.val);
        dfs(node.left, sum);
        dfs(node.right, sum);
        int n = path.remove(path.size()-1);
        sum += n;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}

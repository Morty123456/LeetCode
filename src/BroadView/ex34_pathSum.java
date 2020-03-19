package BroadView;

import java.util.LinkedList;
import java.util.List;

public class ex34_pathSum {
    public static void main(String[] args){
        ex26_thrSubstructureOfaTree a = new ex26_thrSubstructureOfaTree();
        int[] nums = {5,4,8,11,0,13,4,7,2,0,0,5,1};
        TreeNode node = a.makeTreeByNum(nums);
//        a.Inorder(node);
        pathSum(node, 22);
        for (List<Integer> list : pathList)
            System.out.println(list.toString());
    }
    static List<List<Integer>> pathList = new LinkedList<>();
    static List<Integer> path = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        if (root==null)
            return null;
        dfs2(root, sum);
        return pathList;
    }
    public static void  dfs2(TreeNode node, int sum){
        path.add(node.val);
        if (sum==node.val){
            pathList.add(new LinkedList<>(path));
//            System.out.println(path.toString());
            path.remove(path.size()-1);
            return;
        }
        if (node.left!=null)
            dfs2(node.left, sum-node.val);
        if (node.right!=null)
            dfs2(node.right, sum-node.val);
        path.remove(path.size()-1);
    }
    public static void dfs(TreeNode node, int sum){
        path.add(node.val);
        if (node.left==null && node.right==null){
            if (sum==node.val){
                pathList.add(new LinkedList<>(path));
                System.out.println(path.toString());
            }
            path.remove(path.size()-1);
            return;
        }
        if(node.left!=null)
            dfs(node.left, sum - node.val);
        if(node.right!=null)
            dfs(node.right, sum -node.val);
        path.remove(path.size()-1);
    }
}

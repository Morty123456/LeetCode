package BroadView;

import java.util.LinkedList;

public class ex68_lowestCommonAncestor {
    public static void main(String[] args){
        int[] nums = {3,5,1,6,2,10,8,0,0,7,4};
        ex26_thrSubstructureOfaTree a = new ex26_thrSubstructureOfaTree();
        TreeNode root = a.makeTreeByNum(nums);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        LinkedList<TreeNode> listp = new LinkedList<>();
        findPath(root, p, listp);
        LinkedList<TreeNode> listq = new LinkedList<>();
        findPath(root, q, listq);
        TreeNode res = null;
        int i = 0;
        int length = Math.min(listp.size(), listq.size());
        while (i<length && listp.get(i).val == listq.get(i).val){
            res = listp.get(i);
            i++;
        }
        return res;
    }
    public static boolean findPath(TreeNode root, TreeNode p, LinkedList<TreeNode> list){
        if (root==null)
            return false;
        if (root.val==p.val){
            list.add(root);
            return true;
        }
        list.add(root);
        if (findPath(root.left, p, list))
            return true;
        if (findPath(root.right, p, list))
            return true;
        list.remove(list.size()-1);
        return false;
    }
}

package BroadView;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ex68_theRecentCommomFatherNode {
    public static void main(String[] args){
        ex26_thrSubstructureOfaTree a = new ex26_thrSubstructureOfaTree();
        int[] nums = {3,5,1,6,2,9,8,10,0,7,4};
        TreeNode root = a.makeTreeByNum(nums);
//        a.Inorder(root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(2);
        System.out.print(lowestCommonAncestor(root, p, q).val);
    }
    //递归解法
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p.val==root.val || q.val ==root.val)
            return root;
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor2(root.right, p, q);
        if(leftNode == null)
            return rightNode;
        if(rightNode == null)
            return leftNode;
        return root;
    }
    //寻找路径，找到最后一个相同的结点
    //依靠栈来找到路径
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        LinkedList<TreeNode> pList = new LinkedList<>();
        findRoute(root,p, pList);
        LinkedList<TreeNode> qList = new LinkedList<>();
        findRoute(root, q, qList);
        TreeNode publicNode = null;
        int num = Math.min(qList.size(), pList.size());
        for (int i=0;i<num;i++){
            if (pList.get(i)==qList.get(i))
                publicNode=pList.get(i);
            else
                return publicNode;
        }
        return publicNode;
    }
    //寻找二叉树的路径
    public static boolean findRoute(TreeNode root, TreeNode p, LinkedList<TreeNode> ans){
        if (root==null)
            return false;
        if (root.val==p.val){
            ans.add(root);
            return true;
        }
        ans.add(root);
        if (findRoute(root.left,p,ans))
            return true;
        if (findRoute(root.right,p,ans))
            return false;
        ans.remove(ans.size()-1);
        return false;
    }
}

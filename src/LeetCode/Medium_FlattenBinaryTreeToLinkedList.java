package LeetCode;

import java.util.Queue;

/**
 * program: LeetCode
 * description: 修改二叉树
 * Author: wzh
 * create: 2020-02-07 10:40
 */
public class Medium_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args){
        int[] nums = {1,2,5,3,4,0,6};
        A_makeTreeByNums a = new A_makeTreeByNums();
        TreeNode root = a.makeTree(nums);
        Medium_FlattenBinaryTreeToLinkedList mf = new Medium_FlattenBinaryTreeToLinkedList();
//        mf.flatten(root);
        mf.flatten(root);
        while(root!=null){
            System.out.println(root.val);
            root = root.right;
        }
    }
    public void flatten(TreeNode root){
        TreeNode node = new TreeNode(root.val);
        preOrderTraveral(root, node);
        node = node.right.right;
        root.left = null;
        root.right = node;
        //这种没有返回值的void函数
        //不能仅仅简单的使root=node
        //这样的话只在此函数内使root=node
        //返回到上层，root的值依旧没变
        //需要改变root.left和root.right的值
    }
    public TreeNode preOrderTraveral(TreeNode root, TreeNode node){
        //val值为0也代表此处为null
        if (root==null || root.val==0)
            return node;
        node.right = new TreeNode(root.val);
        node = node.right;
        node = preOrderTraveral(root.left, node);
        node = preOrderTraveral(root.right, node);
        return node;
    }
    //lettCode答案
    public void flatten_answer(TreeNode root){
        if (root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right=left;
        TreeNode cur = root;
        while(cur.right!=null)
            cur = cur.right;
        cur.right = right;
    }
}

package BroadView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex26_thrSubstructureOfaTree {
    public static void main(String[] args){
        int[] nums = {3,4,5,1,2};
        int[] nums2 = {4,1,0};
        TreeNode A = makeTreeByNum(nums);
        TreeNode B = makeTreeByNum(nums2);
        System.out.println(isSubStructure(A, B));
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B){
        if (A==null || B==null)
            return false;
        return helper(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right, B);
    }
    public static boolean helper(TreeNode A, TreeNode B){
        if(A==null || B==null)
            return B==null ? true : false;
        if (A.val!=B.val)
            return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
    //根据数组生成二叉树
    public static TreeNode makeTreeByNum(int[] nums){
        if (nums.length==0)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty() && i<nums.length){
            TreeNode node = queue.poll();
            if (nums[i]!=0){
                node.left=new TreeNode(nums[i]);
                queue.offer(node.left);
            }
            if(nums[i+1]!=0){
                node.right=new TreeNode(nums[i+1]);
                queue.offer(node.right);
            }
            i+=2;
        }
        return root;
    }
    //先序遍历
    public static void Inorder(TreeNode node){
        if(node==null)
            return;
        System.out.println(node.val);
        Inorder(node.left);
        Inorder(node.right);
    }
}

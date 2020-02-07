package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * program: LeetCode
 * description: 按照数组顺序生成二叉树，方便以后引用
 * Author: wzh
 * create: 2020-02-07 09:58
 */
public class A_makeTreeByNums {
    public static void main(String[] args){
        int[] nums = {1,2,5,3,4,0,6};
        A_makeTreeByNums a = new A_makeTreeByNums();
        TreeNode root = a.makeTree(nums);
        a.preOrderTraveral(root);
    }
    public TreeNode makeTree(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty() && i<nums.length){
            TreeNode node = queue.poll();
            //这里用0值，代表此处为null
            if (node.val!=0){
                node.left = new TreeNode(nums[i]);
                node.right = new TreeNode(nums[i+1]);
                i += 2;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }
    public void preOrderTraveral(TreeNode root){
        if (root==null || root.val==0)
            return;
        System.out.println(root.val);
        preOrderTraveral(root.left);
        preOrderTraveral(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val=x;
    }
}

package BroadView;

import LeetCode.A_makeTreeByNums;

public class ex55_isBalanced {
    public static void main(String[] args){
        A_makeTreeByNums a = new A_makeTreeByNums();
        int[] nums = {3,9,2,0,0,1,7};
    }
    public static boolean isBalanced(TreeNode root){
        return recur(root)!=-1;
    }
    public static int recur(TreeNode node){
        if (node==null)
            return 0;
        int left = recur(node.left);
        if (left==-1)
            return -1;
        int right = recur(node.right);
        if (right==-1)
            return -1;
        return Math.abs(left-right)<2?Math.max(left, right)+1:-1;
    }
}

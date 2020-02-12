package LeetCode;

//求二叉树的路径最大值
public class Hard_BinaryTreeMaximunPathSum {
    public static void main(String[] args){
        A_makeTreeByNums a = new A_makeTreeByNums();
        int[] nums = {-10,9,20,0,0,15,7};
        TreeNode root = a.makeTree(nums);
        System.out.print(maxPathSum(root));
    }
    static int res = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        res = helper(root);
        return res;
    }
    public static int helper(TreeNode node){
        if (node==null)
            return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        res = Math.max(res, left+right+node.val);
        return node.val+Math.max(left, right);
    }
}
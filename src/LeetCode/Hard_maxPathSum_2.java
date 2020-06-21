package LeetCode;

public class Hard_maxPathSum_2 {
    public static void main(String[] args){
        int[] nums = {10,9,10,0,0,15,7};
        TreeNode root = A_makeTreeByNums.makeTree(nums);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root){
        dfs(root);
        return maxPath;
    }
    static int maxPath = Integer.MIN_VALUE;
    public static int dfs(TreeNode root){
        if (root==null)
            return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int prePath = root.val+left+right;
        maxPath = Math.max(prePath, maxPath);
        return root.val+Math.max(left, right);
    }
}

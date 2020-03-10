package LeetCode;

public class Easy_diameterOfBinaryTree {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        A_makeTreeByNums a = new A_makeTreeByNums();
        TreeNode root = a.makeTree(nums);
//        a.preOrderTraveral(root);
        diameterOfBinaryTree(root);
        System.out.println(max);
    }
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root){
        if (root==null)
            return 0;
        int leftLength = diameterOfBinaryTree(root.left);
        int rightLength = diameterOfBinaryTree(root.right);
        max = Math.max(max, rightLength+leftLength+1);
        return Math.max(leftLength, rightLength)+1;
    }
}

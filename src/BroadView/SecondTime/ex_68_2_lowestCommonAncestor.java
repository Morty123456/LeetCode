package BroadView.SecondTime;

public class ex_68_2_lowestCommonAncestor {
    public static void main(String[] args){

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null || root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null)
            return right;
        if (right==null)
            return left;
        return root;
    }
}

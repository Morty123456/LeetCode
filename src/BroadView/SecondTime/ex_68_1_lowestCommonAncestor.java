package BroadView.SecondTime;

public class ex_68_1_lowestCommonAncestor {
    public static void main(String[] args){

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null || (root.val<=p.val && root.val>=q.val) || (root.val>=p.val && root.val<=q.val))
            return root;
        if (root.val<p.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val>p.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}

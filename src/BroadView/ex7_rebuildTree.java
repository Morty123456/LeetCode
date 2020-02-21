package BroadView;


import java.util.LinkedList;
import java.util.Queue;

public class ex7_rebuildTree {
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        levelBianli(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        TreeNode root = build(preorder, inorder, 0, inorder.length-1, 0);
        return root;
    }
    public static TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart){
        if (inStart>inEnd || preStart>preorder.length)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int mid = 0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==preorder[preStart]){
                mid = i;
                break;
            }
        }
        node.left = build(preorder, inorder, inStart, mid-1, preStart+1);
        node.right = build(preorder, inorder, mid+1, inEnd, preStart+mid-inStart+1);
        return node;
    }
    //树的层次遍历
    public static void levelBianli(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root==null)
            return;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left!=null)
                queue.offer(poll.left);
            if (poll.right!=null)
                queue.offer(poll.right);
        }
        return;
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
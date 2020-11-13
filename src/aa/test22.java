package aa;

import java.util.HashMap;

public class test22 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        int i = 1;
    }
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int[] post;
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        for (int i=0; i<inorder.length; i++){
            hashMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length-1, 0, postorder.length-1);
        return root;
    }
    public static TreeNode buildTree(int iStart, int iEnd, int pStart, int pEnd){
        if (pStart>pEnd || iStart>iEnd)
            return null;
        int rootLocal = hashMap.get(post[iEnd]);
        TreeNode node = new TreeNode(post[pEnd]);
        node.left = buildTree(iStart, rootLocal-1, pStart, pStart+rootLocal-iStart-1);
        node.right = buildTree(rootLocal+1, iEnd, pStart+rootLocal-iStart, pEnd-1);
        return node;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

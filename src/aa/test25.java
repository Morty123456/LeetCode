package aa;

import java.util.HashMap;

public class test25 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = buildTree(pre, in);
        int i = 0;
    }
    static HashMap<Integer, Integer> local  = new HashMap<>();
    static int[] num;
    public static TreeNode buildTree(int[] pre, int[] in){
        for (int i=0; i<in.length; i++){
            local.put(in[i], i);
        }
        num = pre;
        TreeNode root = buildTree(0, pre.length-1, 0, in.length-1);
        return root;
    }
    public static TreeNode buildTree(int pStart, int pEnd, int iStart, int iEnd){
        if (pStart>pEnd || iStart>iEnd)
            return null;
        int root = num[iStart];
        TreeNode node = new TreeNode(root);
        int l = local.get(root);
        node.left = buildTree(pStart, l-1, iStart+1, iStart+l-pStart);
        node.right = buildTree(l+1, pEnd, iStart+l-pStart+1, iEnd);
        return node;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}

package BroadView;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ex7_2_buildTree {
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length==0 || preorder==null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<preorder.length-1;i++)
            map.put(inorder[i], i);
        //递归建立左右子树
        /**
         * preorder：前序遍历的数组
         * preStart：这个字树，前序遍历的起点
         * preEnd：这个子树，前序遍历的终点
         * inorder：中序遍历的数组
         * inStart：这个字数中序遍历的起点
         * inEnd：这个子树中序遍历的终点
         * map：中序遍历的数字及其对应的位置
         * */
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, preorder.length-1, map);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if (preStart>preEnd)
            return null;
        int nodeVal = preorder[preStart];
        TreeNode node = new TreeNode(nodeVal);
        //如果这个子树只有一个节点了，那么它就是个根节点
        if (preStart==preEnd)
            return node;
        else {
            //得到这个根节点在中序遍历中的位置
            int nodeIndex = (int)map.get(nodeVal);
            //这个节点的左子树拥有的节点个数
            int leftNodes = nodeIndex-inStart;
            //这个节点的右子树拥有的节点个数
            int rightNodes = inEnd-nodeIndex;
            //左子树前序遍历：起点+一，终点就是起点+左子树的节点个数
            //左子树中序遍历：起点就是原来的起点，终点是现在父节点的位置-1
            TreeNode left = buildTree(preorder, preStart+1, preStart+leftNodes, inorder, inStart, nodeIndex-1, map);
            //右子树前序遍历：终点就是之前的终点，起点是终点-右子树节点数目+1
            //右子树中序遍历：终点还是原来的终点，起点是父节点的位置+1
            TreeNode right = buildTree(preorder, preEnd-rightNodes+1, preEnd, inorder, nodeIndex+1, inEnd, map);
            node.left = left;
            node.right = right;
            return node;
        }

    }
}

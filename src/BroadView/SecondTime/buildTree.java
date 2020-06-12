package BroadView.SecondTime;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree2(preorder, inorder);
        System.out.println();
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder==null || preorder.length==0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        TreeNode node = buildTree(preorder, inorder, map, 0, preorder.length-1, 0, inorder.length-1);
        return node;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder, Map map, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart>preEnd)
            return null;
        int nodeVal = preorder[preStart];
        TreeNode node = new TreeNode(nodeVal);
        if (preStart==preEnd){
            return node;
        }else {
            int nodeIndex = (int)map.get(nodeVal);
            int leftNodes = nodeIndex-inStart;
            int rightNodes = inEnd-nodeIndex;
            TreeNode left = buildTree(preorder, inorder, map, preStart+1,preStart+leftNodes, inStart, nodeIndex-1);
            TreeNode right = buildTree(preorder, inorder, map, preEnd-rightNodes+1, preEnd, nodeIndex+1, inEnd);
            node.left = left;
            node.right = right;
        }
        return node;
    }
    //写法2
    public static TreeNode buildTree2(int[] preorder, int[] inorder){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        return buildTree2(preorder, map, 0, 0, inorder.length-1);
    }
    //先序遍历的第一个就是根节点
    //然后把先序和中序的数组分成左子树和右子树
    //递归进行调用，建立二叉树
    //重点和难点是，找到先序遍历中，左子树部分和右子树部分
    public static TreeNode buildTree2(int[] preorder, Map map, int preStrat, int inStart, int inEnd){
        if (inStart>inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStrat]);
        int index = (int)map.get(preorder[preStrat]);
        node.left = buildTree2(preorder, map, preStrat+1, inStart, index-1);
        node.right = buildTree2(preorder, map, preStrat+(index-inStart+1), index+1, inEnd);
        return node;
    }
}
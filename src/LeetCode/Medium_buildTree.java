package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/27 14:16
 * @description:
 */
public class Medium_buildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        TreeNode node = nodeBuild(preorder, inorder, 0, 0, inorder.length-1);
        return node;
    }
    public static TreeNode nodeBuild(int[] preorder, int[] inorder, int preLeft, int inLeft, int inRight){
        if (inLeft > inRight)
            return null;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int preIn = 0;
        for (preIn=inLeft;preIn<=inRight;preIn++){
            if (inorder[preIn]==preorder[preLeft]){
                break;
            }
        }
//        int leftNum = preIn-inLeft;
        node.left = nodeBuild(preorder, inorder, preLeft+1, inLeft, preIn-1);
        node.right = nodeBuild(preorder, inorder, preLeft+preIn-inLeft+1, preIn+1, inRight);
        return node;
    }
}

package BroadView;

public class ex36_TreeToList {
    public static void main(String[] args){
        int[] num = {4,2,5,1,3};
        TreeNode root = ex26_thrSubstructureOfaTree.makeTreeByNum(num);
        TreeNode preNode = treeToDoubleList(root);
        int now = preNode.left.val;
        System.out.println(now);
        while (preNode.val!=now){
            System.out.print(preNode.val+" ");
            preNode = preNode.right;
        }
    }
    public static TreeNode treeToDoubleList(TreeNode root){
        if (root==null)
            return null;
        TreeNode node = new TreeNode(0);
        TreeNode preNode = node;
        node = getList(node, root);
        preNode = preNode.right;
        node.right = preNode;
        int nowVal = node.val;
        System.out.println(nowVal);
        while (preNode.val!=nowVal){
            preNode.left = node;
            preNode = preNode.right;
            node = node.right;
        }
        preNode.left = node;
        return preNode.right;
    }
    public static TreeNode getList(TreeNode node, TreeNode curNode){
        if (curNode==null)
            return node;
        node = getList(node ,curNode.left);
        node.right = curNode;
        node = node.right;
        node = getList(node, node.right);
        return node;
    }
}

package BroadView.SecondTime;

public class isSubStructure {
    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
//        node.left.right = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
//        node2.right = new TreeNode(5);
        System.out.println(isSubStructure(node, node2));
    }
    static boolean flage = false;
    public static boolean isSubStructure(TreeNode A, TreeNode B){
//        if (B==null || A==null)
//            return false;
//        return inorder(A, B);
        return (A!=null && B!=null) && (judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public static boolean inorder(TreeNode A, TreeNode B){
        if (flage || A==null)
            return flage;
        if (A.val==B.val)
            flage = judge(A, B);
        flage = inorder(A.left, B) || inorder(A.right, B);
        return flage;
    }
    //判断此节点能不能包含node2结构
    public static boolean judge(TreeNode node1, TreeNode node2){
        if (node2==null)
            return true;
        if (node1==null || node1.val!=node2.val)
            return false;
        boolean res = judge(node1.left, node2.left) && judge(node1.right, node2.right);
        return res;
    }
}

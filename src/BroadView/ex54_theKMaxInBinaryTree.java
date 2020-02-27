package BroadView;


public class ex54_theKMaxInBinaryTree {
    static int count;
    static int result=-1;
    public static void main(String[] args){
        int[] nums = {3,1,4,0,2};
        int k = 1;
        TreeNode root = ex26_thrSubstructureOfaTree.makeTreeByNum(nums);
        System.out.println(kthLargest(root, k));
    }
    public static int kthLargest(TreeNode root, int k){
        count = k;
        PostOrder(root);
        return result;
    }
    public static void PostOrder(TreeNode root){
        if (root!=null){
            PostOrder(root.right);
            if (count==1){
                result=root.val;
                count--;
                return;
            }
            count--;
            PostOrder(root.left);
        }
    }
}

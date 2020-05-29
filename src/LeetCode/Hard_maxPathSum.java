package LeetCode;

public class Hard_maxPathSum {
    public static void main(String[] args){
        int[] nums = {10,9,10,0,0,15,7};
        TreeNode root = A_makeTreeByNums.makeTree(nums);
        System.out.println(maxPathSum(root));
    }
    static int max_sum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }
    public static int max_gain(TreeNode node){
        if (node==null)
            return 0;
        //结点左子树 里面的最大路径
        int left_gain = Math.max(max_gain(node.left), 0);
        //结点右子树 里面的最大路径
        int right_gain = Math.max(max_gain(node.right), 0);
        //此节点作为最大路径的顶点，得到的最大路径的值
        int price_newpath = node.val+left_gain+right_gain;
        //是否比已有的最大值大
        max_sum = Math.max(max_sum, price_newpath);
        //返回此节点的最大单链路径
        return node.val+Math.max(right_gain, left_gain);
    }
}

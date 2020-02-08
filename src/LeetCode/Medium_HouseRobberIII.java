package LeetCode;

/**
 * program: LeetCode
 * description: 小偷，二叉树不想连问题
 * Author: wzh
 * create: 2020-02-07 20:38
 */
public class Medium_HouseRobberIII {
    public static void main(String[] args){
        A_makeTreeByNums a = new A_makeTreeByNums();
        int[] nums = {3,2,3,0,3,0,1};
        TreeNode root = a.makeTree(nums);
        Medium_HouseRobberIII mh = new Medium_HouseRobberIII();
        System.out.println(mh.rob(root));
    }
    public int rob(TreeNode root){
        return robDFS(root)[1];
    }
    public int[] robDFS(TreeNode node){
        //res[0]：不包含当前节点的最大值
        //res[1]：当前结点的最大值
        int[] res = new int[2];
        if (node==null)
            return res;
        int[] l = robDFS(node.left);
        int[] r = robDFS(node.right);
        //不包含当前节点的最大值，就是此节点左子树和右子树之和
        res[0] = l[1] + r[1];
        //当前节点的最大值：不包括此点(左右子树最大值之和)、包含此点(左右子树不包括左右结点的最大值，加上此点的值)
        res[1] = Math.max(res[0], l[0]+r[0]+node.val);
        return res;
    }
}

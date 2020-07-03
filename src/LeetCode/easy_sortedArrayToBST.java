package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/3 9:42
 * @description:
 */
public class easy_sortedArrayToBST {
    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = null;
        node = sortedArrayToBST(nums);
    }
    public static TreeNode sortedArrayToBST(int[] nums){
        TreeNode node = makeTree(nums, 0, nums.length-1);
        return node;
    }
    public static TreeNode makeTree(int[] nums, int left, int right){
        if(left>right)
            return null;
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left  = makeTree(nums, left, mid-1);
        node.right = makeTree(nums, mid+1, right);
        return node;
    }
}

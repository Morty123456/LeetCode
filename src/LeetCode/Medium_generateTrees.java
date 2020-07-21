package LeetCode;

import DesignPatten.Proxy.People;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/7/21 7:47
 * @description:
 */
public class Medium_generateTrees {
    public static void main(String[] args){
        Medium_generateTrees a = new Medium_generateTrees();
        a.generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n){
        List<TreeNode> ans = getTree(1, n);
        int b = 1;
        return ans;
    }
    public List<TreeNode> getTree(int start, int end){
        LinkedList<TreeNode> ans = new LinkedList<>();
        if (start>end){
            ans.add(null);
            return ans;
        }
        if (start==end){
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree = getTree(start, i-1);
            List<TreeNode> rightTree = getTree(i+1, end);
            for (TreeNode left : leftTree){
                for (TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Medium_inorderTraversal {
    public static void main(String[] args){
        int[] nums = {1,0,2,3,0};
//        TreeNode root = A_makeTreeByNums.makeTree(nums);
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        List<Integer> list = diedai(root);
        for (int l : list){
            System.out.print(l+" ");
        }
    }
    static List<Integer> list;
    public static List<Integer> inorderTraversal(TreeNode root){
        list = new LinkedList<>();
        digui(root, list);
        return list;
    }
    public static void digui(TreeNode node, List list){
        if (node==null)
            return;
        digui(node.left, list);
        System.out.println(node.val);
        list.add(node.val);
        digui(node.right, list);
        return;
    }
    //迭代算法，利用栈
    public static List diedai(TreeNode node){
        list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

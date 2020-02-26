package BroadView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ex32_printBinaryTreeFromTopToBottom {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        List<List<Integer>> list = levelOrder(root);
        List<List<Integer>> list = zhiOrder(root);
        for (List<Integer> l : list){
            for (int a : l){
                System.out.print(a+"； ");
            }
            System.out.println("");
        }
    }
    //分层打印
    public static List<List<Integer>> levelOrder(TreeNode root){
        if (root==null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arrList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrint = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(toBePrint==0){
                toBePrint = nextLevel;
                nextLevel = 0;
                arrList.add(list);
//                list.clear();
                list = new LinkedList<>();
            }
            list.add(node.val);
            toBePrint--;
            if (node.left!=null){
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right!=null){
                queue.offer(node.right);
                nextLevel++;
            }
        }
        arrList.add(list);
        return arrList;
    }
    //之字形打印
    public static List<List<Integer>> zhiOrder(TreeNode root){
        List<List<Integer>> arrlist = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(level%2==1){
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if(node.left!=null){
                        stack2.push(node.left);
                    }
                    if (node.right!=null){
                        stack2.push(node.right);
                    }
                }
                arrlist.add(list);
                list = new LinkedList<>();
                level++;
            }
            else {
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right!=null)
                        stack1.add(node.right);
                    if (node.left!=null)
                        stack1.add(node.left);
                }
                arrlist.add(list);
                list = new LinkedList<>();
                level++;
            }
        }
        return arrlist;
    }
}

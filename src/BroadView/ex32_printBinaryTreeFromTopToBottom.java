package BroadView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ex32_printBinaryTreeFromTopToBottom {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = levelOrder(root);
        for (List<Integer> l : list){
            for (int a : l){
                System.out.print(a+" ");
            }
            System.out.println("");
        }
    }
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
}

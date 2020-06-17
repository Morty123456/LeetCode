package BroadView.SecondTime;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public static void main(String[] args){

    }
    public static int[] levelOrder(TreeNode root){
        LinkedList<TreeNode> treeList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root==null)
            return new int[0];
        treeList.addLast(root);
        while (!treeList.isEmpty()){
            TreeNode node = treeList.pollFirst();
            list.addLast(node.val);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left!=null)
                treeList.addLast(left);
            if (right!=null)
                treeList.addLast(right);
        }
        int[] res = new int[list.size()];
        for (int i=0;i<res.length;i++)
            res[i] = list.get(i);
        return res;
    }
    public static List<List<Integer>> levelOrder(TreeNode root, int level){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queueNext = new LinkedList<>();
        queueNext.add(root);
        while (!queueNext.isEmpty()){
            //这里使用new一个新的，就是重新开一个地址来存放新的queueNext
            //这样，queueNext的改变，就不会影响到queue
            queueNext = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queueNext.add(node.left);
                if (node.right!=null)
                    queueNext.add(node.right);
            }
            lists.add(list);
            queue = queueNext;
        }
        return lists;
    }
    public static List<List<Integer>> levelOrder(TreeNode root, boolean fl){
        if (root==null)
            return new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i=queue.size();i>0;i--){
                TreeNode node = queue.poll();
                if (lists.size()%2==0){
                    tmp.addLast(node.val);
                }else
                    tmp.addFirst(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            lists.add(tmp);
        }
        return lists;
    }
}

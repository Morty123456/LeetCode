package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wzh
 * @time: 2020/8/19 16:50
 * @description:
 */
public class Medium_levelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
        for (List list : lists){
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null)
            return lists;
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> path = new LinkedList<>();
            //n这里，代表这一行的大小
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            lists.add(path);
        }
        return lists;
    }
}

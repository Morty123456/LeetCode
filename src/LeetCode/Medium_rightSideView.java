package LeetCode;

import java.util.*;

public class Medium_rightSideView {
    public static void main(String[] args){
        A_makeTreeByNums a = new A_makeTreeByNums();
        int[] nums = {1,2,3,0,5,0,4};
        TreeNode root = a.makeTree(nums);
//        a.preOrderTraveral(root);
        List<Integer> list = rightSideView2(root);
        for (int aa : list)
            System.out.print(aa+" ");
    }
    public static List<Integer> rightSideView(TreeNode root){
        LinkedList<TreeNode> listNode = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if(root==null)
            return null;
        listNode.add(root);
        list.add(root.val);
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        while(!listNode.isEmpty() || !nextLevel.isEmpty()){
            TreeNode node = listNode.poll();
            if(node.left!=null){
//                System.out.println(node.left.val);
                nextLevel.add(node.left);
            }
            if(node.right!=null)
                nextLevel.add(node.right);
            if(listNode.isEmpty() && !nextLevel.isEmpty()){
                list.add(nextLevel.getLast().val);
                listNode = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return list;
    }
    //官方答案
    public static List<Integer> rightSideView2(TreeNode root){
        Map<Integer, Integer> rightMostValueDepth = new HashMap<>();
        int max_depth = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();
            if (node!=null){
                max_depth = Math.max(max_depth, depth);
                rightMostValueDepth.put(depth, node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightMostValueDepth.get(depth));
        }
        return rightView;
    }
}

package NowCoder.wangyi;

import BroadView.SecondTime.TreeNode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/12 14:17
 * @description:
 */
public class test1 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        TreeNode root = null;
        while (n-->0){
            int node1 = sc.nextInt();
            String b = sc.next();
            int node2 = sc.nextInt();
            TreeNode first = null;
            TreeNode second = null;
            if (hashMap.containsKey(node1)){
                first = hashMap.get(node1);
            }else{
                first = new TreeNode(node1);
                hashMap.put(node1, first);
            }
            if (hashMap.containsKey(node2)){
                second = hashMap.get(node2);
            }else{
                second = new TreeNode(node2);
                hashMap.put(node2, second);
            }
            if (root==null)
                root = first;
            if (b.equals("left")){
                first.left = second;
            }else{
                first.right = second;
            }
        }
        dfs(root);
        dfs2(root);
        System.out.println(sum);
    }
    public static void dfs(TreeNode node){
        if (node==null)
            return;
        dfs(node.left);
        if (node.left==null && node.right==null){
            node.yz = true;
        }
        dfs(node.right);
    }
    public static void dfs2(TreeNode node){
        if (node==null)
            return;
        dfs2(node.left);
        if (node.left!=null && node.left.yz && node.right!=null && node.right.yz){
            sum++;
        }
        dfs2(node.right);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        boolean yz = false;
    }
}

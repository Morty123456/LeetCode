package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * program: LeetCode
 * description: 序列化与反序列化二叉树
 * Author: wzh
 * create: 2020-02-08 10:33
 */
public class Hard_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Hard_SerializeAndDeserializeBinaryTree hs = new Hard_SerializeAndDeserializeBinaryTree();
        System.out.println(hs.serialize(root));
    }
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }
    public void helperSerialize(TreeNode node, StringBuilder sb){
        if (node==null){
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        helperSerialize(node.left, sb);
        helperSerialize(node.right, sb);
    }
    public TreeNode deserialize(String data){
        TreeNode root = null;
        return root;
    }
}

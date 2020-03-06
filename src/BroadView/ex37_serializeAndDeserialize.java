package BroadView;

import java.util.LinkedList;
import java.util.Queue;

public class ex37_serializeAndDeserialize {
    public static void main(String[] args){
        ex26_thrSubstructureOfaTree ex26 = new ex26_thrSubstructureOfaTree();
        int[] num = {1,2,3,0,0,4,5};
        TreeNode root = ex26.makeTreeByNum(num);
        System.out.println(seralize(root));
        TreeNode node = deseralize(seralize(root));
        ex26.Inorder(node);
    }
    //序列化
    public static String seralize(TreeNode root){
        if (root==null)
            return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append("[");
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                sb.append(node.val);
                sb.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                sb.append("null,");
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
    //反序列化
    public static TreeNode deseralize(String data){
        if (data==null || data.equals("[]"))
            return null;
        data = data.substring(1, data.length()-1);
        String[] value = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode head = makeTreeNode(value[index++]);
        queue.offer(head);
        TreeNode node = head;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = makeTreeNode(value[index++]);
            node.right = makeTreeNode(value[index++]);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return head;
    }
    public static TreeNode makeTreeNode(String value){
        if (value.equals("null"))
            return null;
        else
            return new TreeNode(Integer.valueOf(value));
    }
}

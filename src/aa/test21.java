package aa;

public class test21 {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root = treeDoublyList(root);
        int i = 1;
    }
    static Node head = null;
    static Node pre = null;
    public static Node treeDoublyList(Node root){
        track(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public static void track(Node node){
        if (node==null)
            return;
        track(node.left);
        if (node.left==null && head==null){
            head = node;
            pre = node;
        }else {
            pre.right = node;
            node.left = pre;
            pre = pre.right;
        }
        track(node.right);
    }
    static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

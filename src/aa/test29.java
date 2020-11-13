package aa;

import java.util.HashMap;

public class test29 {
    public static void main(String[] args) {
        int n = 6;
        Interval[] edges = new Interval[5];
        edges[0] = new Interval(0,1);
        edges[1] = new Interval(1,5);
        edges[2] = new Interval(1,2);
        edges[3] = new Interval(2,3);
        edges[4] = new Interval(2,4);
        int[] values = {3,4,2,1,5};
        int count = solution(n, edges, values);
        System.out.println(count);
    }
    public static int solution(int n, Interval[] Tree_edge, int[] Edge_value){
        TreeNode root = buildTree(Tree_edge, Edge_value);
        dfs(root);
        return max;
    }
    static int max = 0;
    public static int dfs(TreeNode node){
        if (node==null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left+right>max){
            max = left+right;
        }
        return node.val+Math.max(left, right);
    }
    public static TreeNode buildTree(Interval[] edges, int[] values){
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            Interval edge = edges[i];
            if (!map.containsKey(edge.start)){
                map.put(edge.start, new TreeNode(0));
            }
            if (!map.containsKey(edge.end)){
                map.put(edge.end, new TreeNode(values[i]));
            }
            if (map.get(edge.start).left==null){
                map.get(edge.start).left = map.get(edge.end);
            }else {
                map.get(edge.start).right = map.get(edge.end);
            }
        }
        return map.get(edges[0].start);
    }
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

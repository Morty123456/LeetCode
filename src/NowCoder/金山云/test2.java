package NowCoder.金山云;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/9/16 18:48
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] num = new int[strs.length];
        int begin = 0;
        for (String str : strs){
            num[begin++] = strToInt(str);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        TreeNode root = buildTree(num);
        TreeNode node = solution(root, a, b);
        System.out.println(node.val);
    }
    public static TreeNode solution(TreeNode node, int a, int b){
        if (node==null || node.val==a || node.val==b)
            return node;
        TreeNode left = solution(node.left, a, b);
        TreeNode right = solution(node.right, a, b);
        if (left==null)
            return right;
        if (right==null)
            return left;
        return node;
    }
    public static TreeNode buildTree(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i=1; i<nums.length; i++){
            TreeNode node = stack.peek();
            if (node.left!=null && node.right!=null){
                stack.pop();
                i--;
                continue;
            }
            if (node.left==null){
                node.left = new TreeNode(nums[i]);
                if (nums[i]!=-1)
                    stack.push(node.left);
                continue;
            }
            if (node.right==null){
                node.right = new TreeNode(nums[i]);
                if (nums[i]!=-1)
                    stack.push(node.right);
                continue;
            }
        }
        return root;
    }
    public static int strToInt(String s){
        char[] chars = s.toCharArray();
        int sum = 0;
        int judge = 1;
        int begin = 0;
        if (chars[0]=='-'){
            judge=-1;
            begin++;
        }
        while (begin < chars.length){
            sum = sum*10 + chars[begin]-'0';
            begin++;
        }
        return sum*judge;
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

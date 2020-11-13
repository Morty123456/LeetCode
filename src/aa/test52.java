package aa;

import java.util.List;

public class test52 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next= new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow= head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while(left!=null){
            if(left.val == right.val){
                left = left.next;
                right = right.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
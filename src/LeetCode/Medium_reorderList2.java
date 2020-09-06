package LeetCode;

import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/6 14:07
 * @description:
 */
public class Medium_reorderList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        int i = 0;
    }
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while(fast!=null && fast.next!=null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        slow = reverse(slow);
        fast = head;
        ListNode newNode = new ListNode(-1);
        ListNode bl = newNode;
        while (fast!=null && slow!=null){
            bl.next = fast;
            fast = fast.next;
            bl = bl.next;
            bl.next = slow;
            slow = slow.next;
            bl = bl.next;
        }
        if (slow!=null){
            bl.next = slow;
        }
        head = newNode.next;
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
}

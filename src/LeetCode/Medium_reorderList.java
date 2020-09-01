package LeetCode;

import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/31 10:21
 * @description:
 */
public class Medium_reorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList(head);
        int i = 0;
    }
    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode first = head;
        while(first!=null && slow!=null){
            ListNode next = slow.next;
            slow.next = first.next;
            first.next = slow;
            first = slow.next;
            slow = next;
        }
        if(slow!=null){
            first.next = slow;
        }
        first.next.next = null;
        return;
    }
    public static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next = node;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre =node;
            node = next;
        }
        return pre;
    }
}

package aa;

import java.util.Arrays;
import java.util.Comparator;

public class test16 {
    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(4);
        head = sort(head);
        int a = 11;
    }
    public static ListNode sort(ListNode head){
        if (head==null || head.next==null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead, null);
    }
    public static ListNode quickSort(ListNode head, ListNode end){
        if (head==end || head.next==end || head.next.next==end)
            return head;
        ListNode tmpHead = new ListNode(-1);
        ListNode paratition = head.next, p = paratition,tp = tmpHead;
        while (p.next!=end){
            if (p.next.val < paratition.val){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        tp.next = head.next;
        head.next = tmpHead.next;
        quickSort(head, paratition);
        quickSort(paratition, head);
        return head.next;
    }
}

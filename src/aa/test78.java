package aa;

public class test78 {
    public static void main(String[] args) {

    }
    public static ListNode sortList(ListNode head){
        if (head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(next);
        return merge(leftNode, rightNode);
    }
    public static ListNode merge(ListNode leftNode, ListNode rightNode){
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        while (leftNode!=null && rightNode!=null){
            if (leftNode.val<rightNode.val){
                pre.next = leftNode;
                leftNode = leftNode.next;
            }else {
                pre.next = rightNode;
                rightNode = rightNode.next;
            }
            pre = pre.next;
        }
        pre.next = leftNode==null?rightNode:leftNode;
        return tmp.next;
    }
}

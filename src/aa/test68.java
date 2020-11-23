package aa;

public class test68 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = oddEvenList(head);
        while (res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
    public static ListNode oddEvenList(ListNode head){
        if (head==null || head.next==null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode secondHead = second;
        while (first.next.next!=null && second.next.next!=null){
            first.next = first.next.next;
            first = first.next;
            second.next = second.next.next;
            second= second.next;
        }
        while (first.next!=null && first.next.next!=null){
            first.next = first.next.next;
            first = first.next;
        }
        second.next = null;
        first.next = secondHead;
        return head;
    }
}

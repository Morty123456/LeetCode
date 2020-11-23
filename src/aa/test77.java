package aa;

public class test77 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode res = insertionSortList(head);
        while (res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head==null)
            return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode next = head.next;
        ListNode pre = head;
        while (next!=null){
            ListNode now = next;
            ListNode nowNext = now.next;
            now.next = null;
            if (now.val >= pre.val){
                pre = now;
            }else {
                ListNode flage = node;
                while (flage.next.val < now.val){
                    flage = flage.next;
                }
                now.next = flage.next;
                flage.next = now;
            }
            pre.next = nowNext;
            next = nowNext;
        }
        return node.next;
    }
}

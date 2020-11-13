package aa;

public class test34 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = sortInList(head);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode sortInList(ListNode head){
        ListNode res = head;
        while (res!=null){
            ListNode next = res;
            int min = next.val;
            ListNode change = next;
            while (next!=null){
                if (next.val<min){
                    min = next.val;
                    change = next;
                }
                next = next.next;
            }
            change.val = res.val;
            res.val = min;
            res = res.next;
        }
        return head;
    }
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

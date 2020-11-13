package aa;

public class test4 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseKGroup(head, 2);
        int i = 3;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        ListNode end = node;
        while(end!=null){
            for(int i=0; i<k && end!=null; i++){
                end = end.next;
            }
            if(end==null)
                return node.next;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return node.next;
    }
    public static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next= null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre  = node;
            node = next;
        }
        return pre;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

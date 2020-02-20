package BroadView;

public class ex6_reverseOrder {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        if (head==null)
            return;
        ListNode pre = null, cur = head, tmp;
        int count = 0;
        while (cur!=null){
            count++;
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        int[] num = new int[count];
        while (pre!=null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
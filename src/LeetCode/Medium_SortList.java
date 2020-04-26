package LeetCode;


public class Medium_SortList {
    public static void main(String[] args){
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode a = sortList(node);
        System.out.println(a.toString());
    }
    public static ListNode sortList(ListNode head){
        if (head==null ||head.next==null)
            return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next=null;
        return merge(sortList(head), sortList(slow));
    }
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if (l1!=null)
            cur.next=l1;
        if (l2!=null)
            cur.next=l2;
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        ListNode node = this;
        while (node!=null){
            str.append(node.val);
            str.append(" ");
            node=node.next;
        }
        return str.toString();
    }
}

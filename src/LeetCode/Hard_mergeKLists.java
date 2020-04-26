package LeetCode;

public class Hard_mergeKLists {
    public static void main(String[] args){
//        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(3);
//        n1.next.next = new ListNode(7);
//        ListNode n2 = new ListNode(1);
//        n2.next = new ListNode(2);
//        n2.next.next = new ListNode(6);

        ListNode[] lists = new ListNode[2];
        lists[0] = null;
        lists[1] = null;

        System.out.println(mergeLists(lists).toString());

    }
    public static ListNode mergeLists(ListNode[] lists){
        int len = lists.length;
        if (len==0)
            return null;
        if (len==1)
            return lists[0];
        ListNode node = lists[0];
        for (int i=1;i<len;i++){
            node = merge(node, lists[i]);
        }
        return node;
    }
    public static ListNode merge(ListNode node1, ListNode node2){
        if (node1==null)
            return node2;
        if (node2==null)
            return node1;
        ListNode n1 = node1.val<=node2.val ? node1 : node2;
        ListNode n2 = node1.val>node2.val ? node1 : node2;
        ListNode returnNode = new ListNode(n1.val), pre = returnNode;
        n1 = n1.next;
        while (n1!=null && n2!=null){
            if (n1.val<n2.val){
                pre.next = new ListNode(n1.val);
                pre = pre.next;
                n1 = n1.next;
            }
            else{
                pre.next = new ListNode(n2.val);
                pre = pre.next;
                n2 = n2.next;
            }
        }
        if (n1!=null)
            pre.next=n1;
        if (n2!=null)
            pre.next=n2;
        return returnNode;
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/8/26 14:28
 * @description:
 */
public class Hard_reverseKGroup {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = reverseKGroup(node, 2);
        while (node.next!=null){
            System.out.println(node.next.val);
            node = node.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode end = dumy;
        while (end!=null){
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }
            if (end==null)
                break;

            ListNode start = pre.next;
            ListNode nextNode = end.next;
            end.next = null;

            //翻转链表
            ListNode nodeStart = start;
            ListNode preNode = null;
            while (start!=null){
                ListNode next = start.next;
                start.next = preNode;
                preNode = start;
                start = next;
            }

            pre.next.next = nextNode;
            pre.next = preNode;

            pre = nodeStart;
            end = pre;
        }
        return dumy.next;
    }
}

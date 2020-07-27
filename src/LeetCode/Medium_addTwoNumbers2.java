package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/27 20:55
 * @description:
 */
public class Medium_addTwoNumbers2 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(2);
        Medium_addTwoNumbers2 ma = new Medium_addTwoNumbers2();
        ListNode node = ma.addTwoNumbers(l1, l2);
        System.out.println(node.toString());
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
//        l1 = reverse(l1);
//        l2 = reverse(l2);
        ListNode node = new ListNode(0);
        ListNode head = node;
        int overTen = 0;
        while (l1!=null || l2!=null || overTen==1){
            int sum = 0;
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += overTen;
            overTen = sum/10;
            sum = sum%10;
            node.next = new ListNode(sum);
            node = node.next;
        }
        return head.next;
    }
    public ListNode reverse(ListNode node){
        ListNode pre = null, cur = node.next;
        while (node!=null){
            cur = node.next;
            node.next = pre;
            pre = node;
            node = cur;
        }
        return pre;
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/27 22:12
 * @description:
 */
public class Easy_isPalindrome {
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(node));
    }
    public static boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newNode = reverse(slow.next);
        while (newNode!=null){
            if (newNode.val!=head.val)
                return false;
            newNode = newNode.next;
            head = head.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode node){
        ListNode pre = null, cur = null;
        while(node!=null){
            cur = node.next;
            node.next = pre;
            pre = node;
            node = cur;
        }
        return pre;
    }
}

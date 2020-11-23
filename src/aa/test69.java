package aa;

public class test69 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int[] res = solution(head, 3);
        for (int n : res)
            System.out.print(n +" ");

    }
    public static int[] solution(ListNode head, int n){
        ListNode node = head;
        ListNode next = null;
        ListNode pre = null;
        // 反转链表
        while (n-->=0){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head.next = node;
        //构造返回数组
        ListNode pre2 = pre;
        int len = 0;
        //计算长度
        while (pre2!=null){
            pre2 = pre2.next;
            len++;
        }
        int[] res = new int[len];
        int i = 0;
        while (pre!=null){
            res[i] = pre.val;
            i++;
            pre = pre.next;
        }
        return res;
    }
}

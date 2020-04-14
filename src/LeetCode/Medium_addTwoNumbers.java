package LeetCode;

public class Medium_addTwoNumbers {
    public static void main(String[] args){
        Medium_addTwoNumbers ma = new Medium_addTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next=new ListNode(1);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(0);
//        l2.next=new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = ma.addTwoNumbers(l1, l2);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode head = result;
        if (l2==null || l2.val==0)
            return l1;
        if (l1==null || l1.val==0)
            return l2;
        l1 = ReversalList(l1);
        l2 = ReversalList(l2);

        boolean overTen = false;
        while (l1!=null && l2!=null){
            int sum = l1.val+l2.val;
            if (overTen)
                sum += 1;
            if (sum>=10){
                sum -= 10;
                overTen = true;
            }
            else {
                overTen = false;
            }
            ListNode newNode = new ListNode(sum);
            head.next=newNode;
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode surplus = l1 == null ? l2 : l1;
        if (surplus==null){
            if (overTen){
                head.next = new ListNode(1);
            }
        }
        while (surplus!=null){
            if (!overTen){
                head.next=surplus;
                head = head.next;
            }
            else {
                int val = surplus.val;
                if (val==9){
                    head.next = new ListNode(0);
                    head = head.next;
                    overTen = true;
                }
                else {
                    head.next = new ListNode(val+1);
                    head = head.next;
                    overTen = false;
                }
            }
            surplus = surplus.next;
        }
        if (overTen){
            head.next = new ListNode(1);
        }
        return ReversalList(result.next);
    }
    public ListNode ReversalList(ListNode node){
        ListNode pre = null, cur = node, theNext = null;
        while (cur!=null){
            theNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=theNext;
        }
        return pre;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
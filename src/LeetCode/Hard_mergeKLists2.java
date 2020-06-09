package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hard_mergeKLists2 {
    public static void main(String[] args){
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<n;i++){
            lines.add(scanner.nextLine());
        }
        ListNode[] lists = new ListNode[n];
        for(int i=0;i<n;i++){
            String str = lines.get(i);
            ListNode head = new ListNode(0);
            ListNode pre = head;
            String[] s = str.split(" ");
            for (String  ss : s){
                head.next = new ListNode(Integer.valueOf(ss));
                head = head.next;
            }
            lists[i] = pre.next;
        }
        ListNode result = mergeKLists(lists);
        while (result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
//        for (ListNode node : lists){
//            System.out.print(node.val+" ");
//            while (node.next!=null){
//                node = node.next;
//                System.out.print(node.val+" ");
//            }
//            System.out.println();
//        }
    }
    //合并多个链表
    public static ListNode mergeKLists(ListNode[] lists){
        if (lists.length==0)
            return null;
        if (lists.length==1)
            return lists[0];
        ListNode returnNode = lists[0];
        for (int i=1;i<lists.length;i++){
            returnNode = mergeTwo(returnNode, lists[i]);
        }
        return returnNode;
    }
    //合并两个链表
    public static ListNode mergeTwo(ListNode node1, ListNode node2){
        if (node1==null)
            return node2;
        if (node2==null)
            return node1;
        ListNode n1 = node1.val<node2.val?node1:node2;
        ListNode n2 = node1.val<node2.val?node2:node1;
        ListNode returnNode = new ListNode(n1.val);
        n1 = n1.next;
        ListNode pre = returnNode;
        while (n1!=null && n2!=null){
            if (n1.val<n2.val){
                pre.next = new ListNode(n1.val);
                n1 = n1.next;
            }else {
                pre.next = new ListNode(n2.val);
                n2 = n2.next;
            }
            pre = pre.next;
        }
        if (n1!=null)
            pre.next=n1;
        if (n2!=null)
            pre.next=n2;
        return returnNode;
    }
}

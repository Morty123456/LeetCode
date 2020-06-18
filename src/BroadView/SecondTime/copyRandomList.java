package BroadView.SecondTime;

import java.util.HashMap;
import java.util.HashSet;

public class copyRandomList {
    public static void main(String[] args){

    }
    public static Node copyRandomList(Node head){
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node p = head;
        while (p!=null){
            hashMap.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p!=null){
            hashMap.get(p).next = hashMap.get(p.next);
            hashMap.get(p).random = hashMap.get(p.random);
            p = p.next;
        }
        return hashMap.get(head);
    }
}
class Node{
    int val;
    Node next;
    Node random;
    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

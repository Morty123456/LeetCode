package NowCoder.meituan;

import javax.sound.midi.Track;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 9:10
 * @description:
 */
public class meituan_qz_5 {
    static Node head = new Node(0);
    static Node tail = new Node(0);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<Integer, Node> hashMap = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();

        head.next = tail;
        tail.pre = head;

        for (int i = 0; i < m; i++) {
            int now = sc.nextInt();
            if (hashMap.containsKey(now)){
                Node node = hashMap.get(now);
                delete(node);
                add(node);
            }else {
                Node newNode = new Node(now);
                hashMap.put(now, newNode);
                add(newNode);
            }
        }
        int count = hashMap.size();
        Node begin = head.next;
        while (count-->0){
            System.out.println(begin.x);
            begin = begin.next;
        }
    }
    public static void add(Node newNode){
        head.next.pre = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.pre = head;
    }
    public static void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    static class Node{
        int x;
        Node next;
        Node pre;
        public Node(int x) {
            this.x = x;
        }
    }
}

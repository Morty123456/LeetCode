package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Hard_LFUCache {
    public static void main(String[] args){
        Hard_LFUCache hf = new Hard_LFUCache(2);
        hf.put(1,1);
        hf.put(2,2);
        System.out.println(hf.get(1));
        hf.put(3,3);
        System.out.println(hf.get(2));
        System.out.println(hf.get(3));
        hf.put(4,4);
        System.out.println(hf.get(1));
        System.out.println(hf.get(3));
        System.out.println(hf.get(4));

    }
    HashMap<Integer, Node> cache;
    HashMap<Integer, LinkedHashSet<Node>> freqMap;
    int size;
    int capacity;
    int min;

    public Hard_LFUCache(int capacity){
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    public int get(int key){
        Node node = cache.get(key);
        if (node==null)
            return -1;
        freqIn(node);
        return node.value;
    }
    public void put(int key, int value){
        if (capacity==0)
            return;
        Node node = cache.get(key);
        if (node!=null){
            node.value=value;
            freqIn(node);
        }
        else {
            if (size==capacity){
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }
    public void freqIn(Node node){
        //删除旧的结点
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq==min && set.size()==0)
            min = freq+1;
        //在新的freq链表，加入新的结点
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq+1);
        if (newSet==null){
            newSet = new LinkedHashSet<>();
            freqMap.put(freq+1, newSet);
        }
        newSet.add(node);
    }
    public void addNode(Node node){
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set==null){
            set = new LinkedHashSet<>();
            freqMap.put(1,set);
        }
        set.add(node);
        min=1;
    }
    public Node removeNode(){
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}
class Node{
    int key;
    int value;
    int freq = 1;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

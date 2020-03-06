package algorithm;

import java.util.*;

//集合类的用法
public class javaCollection {
    public static void main(String[] args){
        //定义范围可以比较大，new必须具体
        Map<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        HashSet<Integer> hashSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();

//        listExample();
//        setExample();
//        sollectionExample();
    }
    public static void sollectionExample(){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(1,2);
        Iterator<Integer> it = hashMap.keySet().iterator();
        while (it.hasNext())
            System.out.println(it.next()+" ");
        System.out.println(hashMap.containsKey(1));
    }
    public static void setExample(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        for (int a:set)
            System.out.print(a+" ");
        System.out.println();
        set.remove(set.size()-1);
        for (int a:set)
            System.out.print(a+" ");
        System.out.println();
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(2);
        for (int a:treeSet)
            System.out.print(a+" ");
        System.out.println();
        System.out.println(treeSet.contains(2));
    }
    public static void listExample(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        arrayList.add(1);
        arrayList.add(2);
        for (int a: arrayList)
            System.out.print(a);
        System.out.println();
        arrayList.remove(arrayList.size()-1);
        for (int a: arrayList)
            System.out.print(a);
        System.out.println();

        linkedList.add(1);
        linkedList.add(2);
        for (int a: linkedList)
            System.out.print(a);
        System.out.println();
    }
}

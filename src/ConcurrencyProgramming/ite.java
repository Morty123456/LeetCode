package ConcurrencyProgramming;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: wzh
 * @time: 2020/7/7 18:20
 * @description:
 */
public class ite {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i==2)
                iterator.remove();
        }
        Iterator<Integer> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            Integer i = iterator2.next();
            System.out.println(i);
        }
    }
}

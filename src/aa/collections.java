package aa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/7/16 16:21
 * @description:
 */
public class collections {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            System.out.println(n);

        }
    }
}

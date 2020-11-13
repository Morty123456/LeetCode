package aa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test38 {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = maxInWindows(num, 0);
        for (int n : list)
            System.out.print(n+" ");
    }
    public static ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int end = -size+1;
        if (size==0)
            return list;
        for (int i=0; i<num.length; i++){
            while (!queue.isEmpty() && queue.getLast()<num[i]){
                queue.removeLast();
            }
            queue.addLast(num[i]);
            if (end>=0){
                list.add(queue.peekFirst());
                if (num[end]==queue.peekFirst())
                    queue.removeFirst();
            }
            end++;
        }
        return list;
    }
}

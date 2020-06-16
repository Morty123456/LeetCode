package BroadView.SecondTime;

import java.util.LinkedList;

public class validateStackSequences {
    public static void main(String[] args){
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,5,2,1};
        System.out.println(validateStackSequences(pushed, poped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped){
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i = 0, j = 0;
        while (i<pushed.length){
            if (pushed[i]==popped[j]){
                i++;j++;
            }
            else if(linkedList.isEmpty() || linkedList.peekLast()!=popped[j]){
                linkedList.addLast(pushed[i]);
                i++;
            }
            else if (linkedList.getLast()==popped[j]){
                linkedList.removeLast();
                j++;
            }
            else
                return false;
        }
        while (!linkedList.isEmpty()){
            if (linkedList.pollLast()==popped[j])
                j++;
            else
                return false;
        }
        return true;
    }
    public static boolean validateStackSequences2(int[] pushed, int[] popped){
        int i = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num: pushed){
            list.addLast(num);
            while (!list.isEmpty() && list.peekLast()==pushed[i]){
                list.pollLast();
                i++;
            }
        }
        return list.isEmpty();
    }
}

package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Easy_hasGroupsSizeX {
    public static void main(String[] args){
        int[] num = {1,2,3,4,4,3,2,1};
        int[] num2 = {1,1,1,2,2,2,3,3};
        int[] num3 = {1,1,2,2,2,2};
        System.out.println(hasGroupsSizeX(num3));
    }
    public static boolean hasGroupsSizeX(int[] deck){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : deck){
            if (map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count+1);
            }
            else
                map.put(num, 1);
        }
        int size = map.size();
        int[] num = new int[size];
        int i=0;
        Iterator maplit = map.entrySet().iterator();
        while (maplit.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) maplit.next();
            num[i++]=entry.getValue();
//            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        if (size==1){
            return num[0]>=2;
        }
        Arrays.sort(num);
        int groupNumOfNumZero = 1;
        while (groupNumOfNumZero<=num[0]/2){
            if (num[0]%groupNumOfNumZero==0){
                int group = num[0]/groupNumOfNumZero;
                boolean canDivide = true;
                for (int j=1;j<size;j++){
                    if (num[j]%group==0)
                        continue;
                    else {
                        canDivide = false;
                        break;
                    }
                }
                if (canDivide)
                    return true;
            }
            groupNumOfNumZero++;
        }
        return false;
    }
}

package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Medium_canCompleteCircuit {
    public static void main(String[] args){
        int[] gas = {5};
        int[] cost = {5};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> list = new LinkedList();
        int len = gas.length;
        for(int i=0;i<len;i++){
            if(gas[i]>=cost[i]){
                list.add(i);
            }
        }
        for(int begin : list){
            int oil=0;
            boolean flage = true;
            for(int i=begin;i<len;i++){
                oil += gas[i]-cost[i];
                if(oil<0){
                    flage=false;
                    break;
                }
            }
            if(flage){
                int i=0;
                for(i=0;i<begin;i++){
                    oil += gas[i]-cost[i];
                    if(oil<0){
                        flage=false;
                        break;
                    }
                }
                if(i==begin)
                    return begin;
            }
        }
        return -1;
    }
}

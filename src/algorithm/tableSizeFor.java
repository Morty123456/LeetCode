package algorithm;

import java.util.HashMap;
import java.util.Map;

public class tableSizeFor {
    public static void main(String[] args){
        Map  map = new HashMap();
        int cap1 = 2;
        int cap2 = 7;
        int cap3 = 0;
        System.out.println(tableSizeFor(cap3));
//        System.out.println(tableSizeFor(cap2));
    }
    public static final int tableSizeFor(int cap){
        int n = cap - 1;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;
        return (n < 0) ? 1 : (n >= (1<<30) ) ? (1<<30) : n+1;
    }
}

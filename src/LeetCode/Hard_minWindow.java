package LeetCode;

import java.util.*;

public class Hard_minWindow {
    public static void main(String[] args){
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t){
        HashMap<Character, Integer> tMap = new HashMap<>();
//        HashMap<Character, Integer> neeedMap = new HashMap<>();
        for (char tChar : t.toCharArray()){
            if (!tMap.containsKey(tChar))
                tMap.put(tChar,0);
            else
                tMap.put(tChar, tMap.get(tChar)-1);
        }

        char[] sCharArray = s.toCharArray();
        int begin = 0 , end = 0, minWindow = s.length()+1;
        int minBegin = 0, minEnd = s.length()+1;
        for (end=0;end<s.length();){
            while (getMinValue(tMap)<1 && end<s.length()){
                if (tMap.containsKey(sCharArray[end]))
                    tMap.put(sCharArray[end], tMap.get(sCharArray[end])+1);
                end++;
            }
            while (begin<end && getMinValue(tMap)>0){
                if (end-begin<minWindow){
                    minBegin=begin;minEnd=end;
                    minWindow=end-begin;
                }
                if (tMap.containsKey(sCharArray[begin])){
                    tMap.put(sCharArray[begin], tMap.get(sCharArray[begin])-1);
                }
                begin++;
            }
        }
        if (minWindow<=s.length())
            return (s.substring(minBegin, minEnd));
        return "";
    }
    public static int getMinValue(Map<Character, Integer> map) {
        int min = 1;
        for (int v : map.values()){
            if (v<min)
                min=v;
        }
        return min;
    }
}

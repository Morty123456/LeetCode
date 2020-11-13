package aa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class test32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(graph_circle_checker(str));
    }
    public static int graph_circle_checker(String graph_string){
        if (graph_string.charAt(0)!='{' || graph_string.charAt(graph_string.length()-1)!='}')
            return -1;
        HashMap<String, HashSet<String>> edge = new HashMap<>();
        HashMap<String, Integer> ruDu = new HashMap<>();
        String[] strs =graph_string.substring(1, graph_string.length()-1).split(",");
        int n = strs.length;
        for (String str : strs){
            if (str.charAt(0)!='(' || str.charAt(str.length()-1)!=')')
                return -1;
            str = str.substring(1, str.length()-1);
            StringBuffer begin = new StringBuffer();
            StringBuffer end = new StringBuffer();
            char[] chars = str.toCharArray();
            boolean flage = true;
            for (int i=0; i<chars.length; i++){
                if (chars[i]=='-' && chars[i+1]=='>'){
                    flage = false;
                    i += 2;
                }
                if (flage)
                    begin.append(chars[i]);
                else
                    end.append(chars[i]);
            }
            String e = end.toString();
            String b = begin.toString();
            if (edge.containsKey(b)){
                HashSet<String> set = edge.get(b);
                set.add(e);
            }else {
                HashSet<String> set = new HashSet<>();
                set.add(e);
                edge.put(b, set);
            }
            if (ruDu.containsKey(e)){
                ruDu.put(e, ruDu.get(e)+1);
            }else {
                ruDu.put(e, 1);
            }
            if (!ruDu.containsKey(b))
                ruDu.put(b, 0);
        }
        return judge(ruDu, edge, n);
    }
    public static int judge(HashMap<String, Integer> RuDu, HashMap<String, HashSet<String>> edge, int n){
        while (n-->0){
            for (String node : RuDu.keySet()){
                if (RuDu.get(node)==0){
                    if (!edge.containsKey(node))
                        continue;
                    HashSet<String> set = edge.get(node);
                    for (String end : set){
                        RuDu.put(end, RuDu.get(end)>0?RuDu.get(end)-1:0);
                    }
                }
            }
        }
        for (String node : RuDu.keySet()){
            if (RuDu.get(node)!=0)
                return 1;
        }
        return 0;
    }
}

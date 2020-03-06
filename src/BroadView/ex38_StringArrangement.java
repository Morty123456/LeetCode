package BroadView;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ex38_StringArrangement {
    public static void main(String[] args){
        String s = "abc";
        String[] str = permutation(s);
        for (String aa : str)
            System.out.println(aa);
    }
    static Set<String> set = new HashSet<>();
    public static String[] permutation(String s){
        if (s==null)
            return new String[]{};
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return set.toArray(new String[set.size()]);
    }
    public static void process(String s, String letter, boolean[] visited){
        if (s.length()==letter.length()){
            set.add(letter);
            return;
        }
        for (int i=0;i<s.length();i++){
            if (!visited[i]){
                visited[i] = true;
                process(s, letter+String.valueOf(s.charAt(i)), visited);
                visited[i] = false;
            }
        }
    }
}

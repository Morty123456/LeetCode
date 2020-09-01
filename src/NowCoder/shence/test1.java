package NowCoder.shence;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/1 13:37
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<Character>> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        solution(list, new LinkedList<>(), chars, visited);
        String res = "";
        for (List<Character> l : list){
            res += " '";
            for (char ch : l){
                res+=ch;
            }
            res += "',";
        }
        res = res.substring(1, res.length()-1);
        System.out.println("["+res+"]");
    }
    public static void solution(List<List<Character>> lists, List<Character> path, char[] chars, boolean[] visited){
        if (path.size()==chars.length){
            lists.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (!visited[i]){
                path.add(chars[i]);
                visited[i] = true;
                solution(lists, path, chars, visited);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}

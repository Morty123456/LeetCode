package NowCoder.xiecheng;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/9/8 19:30
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        solution(strs);
    }
    static List<String> list = new LinkedList<>();
    public static void solution(String[] strings){
        int len = strings.length;
        StringBuffer sb = new StringBuffer();
        dfs(strings, sb, 0, len);
        for (String str : list){
            if (isHuiLu(str)){
                System.out.println(str+"--circular dependency");
            }else
                System.out.println(str);
        }
    }
    public static void dfs(String[] strings, StringBuffer sb, int now, int len){
        if (now==len){
            list.add(sb.toString());
        }else {
            for (int i=0; i<strings[now].length(); i++){
                sb.append(strings[now].charAt(i));
                dfs(strings, sb, now+1, len);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
    public static boolean isHuiLu(String s){
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()){
            if (set.contains(ch))
                return true;
            else
                set.add(ch);
        }
        return false;
    }
}

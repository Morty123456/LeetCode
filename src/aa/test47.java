package aa;

import java.util.*;

public class test47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> list = new LinkedList<>();
        String user = "";
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] strs = str.split(",");
            if (strs.length==2)
                list.add(strs);
            else{
                user = str;
                break;
            }

        }
        System.out.println(solution(list, user));
    }
    public static int solution(List<String[]> loginInfo, String userId){
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, LinkedList<String>> UserToLocal = new HashMap<>();
        HashMap<String, LinkedList<String>> LocalToUser = new HashMap<>();
        for (String[] strs : loginInfo){
            String user = strs[0];
            String local = strs[1];
            if (UserToLocal.containsKey(user)){
                LinkedList<String> l = UserToLocal.get(user);
                l.add(local);
                UserToLocal.put(user, l);
            }else {
                LinkedList<String> l = new LinkedList<>();
                l.add(local);
                UserToLocal.put(user, l);
            }
            if (LocalToUser.containsKey(local)){
                LinkedList<String> l = LocalToUser.get(local);
                l.add(user);
                LocalToUser.put(local, l);
            }else {
                LinkedList<String> l = new LinkedList<>();
                l.add(user);
                LocalToUser.put(local, l);
            }
        }
        hashSet.add(userId);
        Stack<String> stack = new Stack<>();
        stack.push(userId);
        while (!stack.isEmpty()){
            String user = stack.pop();
            LinkedList<String> local = UserToLocal.get(user);
            for (String l : local){
                LinkedList<String> users = LocalToUser.get(l);
                for (String u : users){
                    if (!hashSet.contains(u)){
                        hashSet.add(u);
                        stack.add(u);
                    }
                }
            }
        }
        return hashSet.size();
    }
}

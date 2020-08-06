package NowCoder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/6 8:13
 * @description:
 */
public class ningmeng {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int length = s.length();
//        int mid = 0;
//        for (int i=0;i<length;i++){
//            if (s.charAt(i)==','){
//                mid=i;
//                break;
//            }
//        }
//        String pattern = s.substring(1, mid-1);
//        String str = s.substring(mid+2, length-1);
//        System.out.println(testMatch(pattern, str));
//    }
//    public static boolean testMatch (String pattern, String str){
//        HashMap<Character, String> map = new HashMap<>();
//        char[] ch = pattern.toCharArray();
//        String[] strs = str.split(" ");
//        if (ch.length!=strs.length)
//            return false;
//        for (int i=0;i<ch.length;i++){
//            if (map.containsKey(ch[i])){
//                if (!map.get(ch[i]).equals(strs[i]))
//                    return false;
//            }
//            map.put(ch[i], strs[i]);
//        }
//        return true;
//    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        System.out.println(findGreaterNum(422154));
    }
    public static int findGreaterNum (int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (n!=0){
            int y = n%10;
            n /= 10;
            if (list.isEmpty() || list.getLast()<=y){
                add(list, y);
            }
//                list.addFirst(y);
            else {
                n = n * 10 + list.removeFirst();
                n = n * 10 +y;
                while (!list.isEmpty()){
                    n = n*10 + list.removeFirst();
                }
                return n;
            }
        }
        return -1;
    }
    public static void add(LinkedList<Integer> list, int k){
        for (int i=0;i<list.size();i++){
            if (list.get(i)>k){
                list.add(i-1, k);
                return;
            }
        }
        list.add(list.size(), k);
    }
}

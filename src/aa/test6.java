package aa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer>[] arrayLists = new ArrayList[n];
        sc.nextLine();
        for (int i=0; i<n; i++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            for (String ss : strs){
                arrayList.add(strToInt(ss));
            }
            arrayLists[i] = arrayList;
        }
        int num = solution(arrayLists, m);
        System.out.println(num);
    }
    public static int solution(ArrayList<Integer>[] arrayLists, int m){
        HashMap<Integer, Integer> in = new HashMap<>();
        HashSet<Integer> notMatch = new HashSet<>();
        for (int i=0; i<m; i++){
            ArrayList<Integer> thisNode = arrayLists[i];
            for (int j=1; j<thisNode.size(); j++){
                if (in.containsKey(thisNode.get(j))){
                    notMatch.add(thisNode.get(j));
                    in.put(thisNode.get(j), in.get(thisNode.get(j))+1);
                }else{
                    in.put(thisNode.get(j), 1);
                }
            }
        }
        for (int i=m; i<arrayLists.length; i++){
            ArrayList<Integer> preNode = arrayLists[i-m];
            for (int j=1; j<preNode.size(); j++){
                if (in.containsKey(preNode.get(j)) && in.get(preNode.get(j))==1)
                    in.remove(preNode.get(j));
                else
                    in.put(preNode.get(j), in.get(preNode.get(j))-1);
            }
            ArrayList<Integer> nowNode = arrayLists[i];
            for (int j=1; j<nowNode.size(); j++){
                if (in.containsKey(nowNode.get(j))){
                    notMatch.add(nowNode.get(j));
                    in.put(nowNode.get(j), in.get(nowNode.get(j))+1);
                }else{
                    in.put(nowNode.get(j), 1);
                }
            }
        }
        for (int i=0;i<m-1;i++){

        }
        return notMatch.size();
    }
    public static int strToInt(String str){
        int sum = 0;
        for (char ch : str.toCharArray()){
            sum += sum*10 + ch-'0';
        }
        return sum;
    }
}

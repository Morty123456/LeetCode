package aa;

import java.util.Scanner;
import java.util.TreeSet;

public class test46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int n = sc.nextInt();
            sc.nextLine();
            TreeSet<Integer> zero = new TreeSet<>();
            TreeSet<Integer> hasOne = new TreeSet<>();
            char[] number = sc.nextLine().toCharArray();

            for (int j=0; j<n; j++){
                char num = number[j];
                if (num=='0')
                    zero.add(j+1);
                else if (num=='1')
                    hasOne.add(j+1);
            }
            int m = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            solution(str, zero, hasOne);
        }
    }
    public static void solution(String str, TreeSet<Integer> zero, TreeSet<Integer> hasOne){
        char[] chars = str.toCharArray();
        int[] res = new int[chars.length];
        for (int i=0; i<chars.length; i++){
            char ch = chars[i];
            int local = 0;
            if (ch=='M'){
                if (hasOne.isEmpty()){
                    local = zero.pollFirst();
                    hasOne.add(local);
                }else {
                    local = hasOne.pollFirst();
                }
            }else {
                if (zero.isEmpty()){
                    local = hasOne.pollFirst();
                }else {
                    local = zero.pollFirst();
                    hasOne.add(local);
                }
            }
            res[i] = local;
        }
        for (int num : res)
            System.out.println(num);
    }
}

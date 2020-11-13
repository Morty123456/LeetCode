package aa;

import java.util.HashMap;
import java.util.Scanner;

public class test24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(solve(M, N));
    }
    public static String solve(int M, int N){
        String sb = "";
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        map.put(16, 'G');
        int flage = 1;
        if (M<0){
            flage = -1;
            M = -M;
        }
        while (M>0){
            int num = M%N;
            M /= N;
            if (num>=0 && num<=9){
                sb = num + sb;
            }else {
                sb = map.get(num) + sb;
            }
        }
        if (flage<0){
            sb = '-'+sb;
        }
        return sb.toString();
    }
}

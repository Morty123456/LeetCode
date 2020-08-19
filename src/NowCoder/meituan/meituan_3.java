package NowCoder.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class meituan_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        int m = sc.nextInt();
        for (int i=0;i<m;i++){
            int op = sc.nextInt();
            int pos = sc.nextInt();
            if (op==1)
                //被摧毁
                hashSet.add(pos);
            if (op==2)
                System.out.println(findHome(hashSet, pos, n));
        }
    }
    public static int findHome(HashSet hashSet, int local, int n){
        for(int i=local;i<=n;i++){
            if (!hashSet.contains(i))
                return i;
        }
        return -1;
    }
}

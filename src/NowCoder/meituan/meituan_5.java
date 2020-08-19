package NowCoder.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class meituan_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] result = new int[n];
        for (int i=0;i<n;i++){
            num[i] = sc.nextInt();
            result[i] = -1;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<n;i++){
            if (hashSet.contains(num[i])){
                result[i]=1;
                continue;
            }
            for (int j=i+1;j<n;j++){
                if ((num[i]&num[j])==0){
                    result[i]=1;
                    result[j]=1;
                    hashSet.add(num[i]);
                    hashSet.add(num[j]);
                }
            }
        }
        for (int re : result)
            System.out.print(re+" ");
    }
}

package NowCoder.meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/6 9:10
 * @description:
 */
public class meituan_qz_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i=0;i<n;i++){
                num[i] = sc.nextInt();
            }
            System.out.println(isCan(n, num));
        }

    }
    public static boolean isCan(int n, int[] num){
        Arrays.sort(num);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int now : num){
            if (now==1)
                hashMap.put(1, hashMap.get(1)+1);

        }

        return true;
    }
}

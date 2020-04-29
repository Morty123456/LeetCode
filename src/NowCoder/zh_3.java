package NowCoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class zh_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        for (int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int number : num){
            if (hashMap.containsKey(number))
                hashMap.put(number,hashMap.get(number)+1);
            else
                hashMap.put(number,1);
        }
    }
    public static int getNum(int[] num, int n, int k, HashMap<Integer, Integer> hashMap, int count, int block){
        if (hashMap.containsValue(k))
            return count;
        while(!hashMap.containsValue(k)){
            if (block==0){
                int number = num[n-1];
                num[n-1]--;
                Arrays.sort(num);
                hashMap.put(number, hashMap.get(number)+1);
                if (hashMap.containsKey(number-1))
                    hashMap.put(number-1,hashMap.get(number-1)+1);
                else
                    hashMap.put(number-1,1);
                count++;
                return count;
            }
        }

        return 0;

    }
}

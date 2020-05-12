package NowCoder;

import java.util.Scanner;

public class meituan_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i=0;i<n;i++)
            num[i] = sc.nextInt();
        int maxHaming = 0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int number = num[i]^num[j];
                int thisHaming = getNum(number);
                maxHaming=thisHaming>maxHaming?thisHaming:maxHaming;
            }
        }
        System.out.print(maxHaming);
    }
    public static int getNum(int n){
        int count=0;
        while (n>0){
            if (n%2==1)
                count++;
            n /= 2;
        }
        return count;
    }
}

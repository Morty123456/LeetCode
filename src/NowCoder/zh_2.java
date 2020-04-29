package NowCoder;

import java.util.Scanner;

public class zh_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[2*n];
        for (int i=0;i<2*n;i++){
            num[i] = sc.nextInt();
        }
        int count = 0;
        for (int i=1;i<2*n;i+=2){
            if (num[i-1]%2==0 && num[i]-num[i-1]==1 || num[i-1]%2==1 && num[i-1]-num[i]==1)
                continue;
            else{
                int find = 0;
                if (num[i-1]%2==0)
                    find = num[i-1]+1;
                else
                    find = num[i-1]-1;
                for (int j=i+1;j<2*n;j++){
                    if (num[j]==find){
                        num[i] = num[i]+num[j]-(num[j]=num[i]);
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
}

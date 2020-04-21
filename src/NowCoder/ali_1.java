package NowCoder;

import java.util.Scanner;

public class ali_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int a = 0, length = 0;
        for(int i=L;i<=100;i++){
//            System.out.println((2*N-i*i+i));
//            System.out.println((2*i));
            if((2*N-i*i+i)%(2*i)==0){
                a = (2*N-i*i+i)/(2*i);
                length = i;
                break;
            }
        }
        if(a==0)
            System.out.println("No");
        else{
            for(int i=0;i<length;i++)
                System.out.print(a+i+" ");
        }
    }
}

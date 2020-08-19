package NowCoder.wangyi;

import java.util.Scanner;

public class wangyi_anludeng {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            getCount(str);
        }
    }
    public static void getCount(String str){
        char[] ch = str.toCharArray();
        int length = ch.length;
        int count = 0;
        for(int i=0;i<length;i++){
//            System.out.println("这里是："+ch[i]);
            if(ch[i]=='.'){
                count++;
                if(i+2<length){
                    ch[i+1]='L';
                    ch[i+2]='L';
                }
                else{
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

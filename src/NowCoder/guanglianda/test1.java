package NowCoder.guanglianda;

import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/8/19 18:24
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        int count = 0;
        for (int i=0;i<array1.length;i++){
            if (array1[i]==array2[i]){
                count+=20;
            }else if (count>0){
                count -= 10;
            }
        }
        System.out.println(count);
    }
}

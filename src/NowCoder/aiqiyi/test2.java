package NowCoder.aiqiyi;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/8/23 14:30
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        HashSet<int[]> hashSet = new HashSet<>();
        int nowX = 0, nowY = 0;
        int[] local = {0,0};
//        hashSet.add(local);
        List<int[]> list = new ArrayList<>();
        list.add(local);
        char[] chars = s.toCharArray();
        int i = 0;
        boolean flage = false;
        for (i=0;i<chars.length;i++){
            char ch = chars[i];
            if (ch=='E')
                nowX++;
            else if (ch=='S')
                nowY++;
            else if (ch=='W')
                nowX--;
            else if (ch=='N')
                nowY--;
            int[] num = {nowX, nowY};
            list.add(num);
            for (int j=0;j<list.size()-2;j++){
                int[] nu = list.get(j);
                if (nu[0]==num[0] && nu[1]==num[1]) {
                    System.out.println("True");
                    flage = true;
                    break;
                }
            }
            if (flage)
                break;
//            if (list.contains(local)){
//                System.out.println("True");
//                break;
//            }
        }
        if (!flage)
            System.out.println("False");
    }
}

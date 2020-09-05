package NowCoder.sougou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/9/5 18:31
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(getPasswordCount(str));
    }
    public static long getPasswordCount (String password) {
        int[] num = new int[password.length()];
        for (int i=0; i<num.length; i++){
            num[i] = password.charAt(i)-'0';
        }
        long count = 0;
        for (int i=1; i<=9; i++){

            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            lists.add(arrayList);
            arrayList.add(i);

            int j = 1;
            while (j<num.length) {

                for (ArrayList<Integer> a : lists){
                    int now = a.get(a.size()-1)+num[j];
                    if (now%2==0){
                        a.add(now/2);
                    }else {
                        ArrayList<Integer> b = new ArrayList<>(a);
                        a.add(now/2);
                        b.add(now/2+1);
                        lists.add(b);
                    }
                }
                j++;
            }
            count += lists.size();

        }
        return count;
    }
}

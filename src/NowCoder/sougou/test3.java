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
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dfs(password, "", i, 1,password.length());
        }
        return res;
    }
    public static boolean flage = false;
    public static long dfs(String password, String cur, int num, int curLength, int passwordLength){
        cur += num;
        if (curLength == passwordLength){
            if (cur.equals(password)){
                flage = true;
            }
            return 1;
        }
        int curNum = password.charAt(curLength)-'0';
        int sum = curNum + num;
        if ((sum&2)==1){
            return dfs(password, cur, sum/2, curLength+1, passwordLength) + dfs(password, cur, sum/2+1, curLength+1, passwordLength);
        }else {
            return dfs(password, cur, sum/2, curLength+1, passwordLength);
        }
    }
}

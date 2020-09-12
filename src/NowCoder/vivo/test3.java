package NowCoder.vivo;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/9/12 20:21
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length()-1);
        String[] strs = s.split(",");
        int[] num = new int[strs.length];
        for (int i=0;i<num.length;i++){
            num[i] = strToInt(strs[i]);
        }
        solution(num);
    }
    public static void solution(int[] nums){
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        for (int i=0;i<len;i++){
            if (nums[i]==-1) {
                set.add(i);
                list.add(i);
                visited[i] = true;
            }
        }
        while (list.size()<len){
            for (int i=0;i<len;i++){
                if (set.contains(nums[i]) && !visited[i]){
                    list.add(i);
                    set.add(i);
                    visited[i] = true;
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append('"');
        for (int i=0;i<len-1;i++){
            sb.append(list.get(i));
            sb.append(",");
        }
        sb.append(list.get(len-1));
        sb.append('"');
        System.out.println(sb.toString());
    }
    public static int strToInt(String str){
        char[] chars = str.toCharArray();
        int a = 1;
        int sum = 0;
        for (int i=chars.length-1; i>=0; i--){
            if (chars[i]=='-')
                return -1*sum;
            sum += a*(chars[i]-'0');
            a *= 10;
        }
        return sum;
    }
}

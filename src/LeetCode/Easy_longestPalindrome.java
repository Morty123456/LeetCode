package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Easy_longestPalindrome {
    public static void main(String[] args){
        String str = "abccccdd";
        System.out.println(longest(str));
    }
    public static int longest(String str){
        char[] chr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chr){
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        int max = 0;
        int sum = 0;
        boolean hasJs = false;
        Iterator<Map.Entry<Character, Integer>> maplit = map.entrySet().iterator();
        while (maplit.hasNext()){
            Map.Entry<Character, Integer> entry = maplit.next();
            if (entry.getValue()%2==0)
                sum += entry.getValue();
            else{
                sum += entry.getValue()-1;
                hasJs = true;
            }
        }
        if (hasJs)
            sum += 1;
        return sum;
    }
    public static int longestPalindrome(String str){
        //预处理字符串
        str = preHandleString(str);
        //处理后的字符串长度
        int length = str.length();
        //右边界
        int rightSide = 0;
        //右边界对应的回文串中心
        int rightCenter = 0;
        //保存每个字符为中心的回文串长度的一半
        int[] halfLenArr = new int[length];
        //记录回文中心
        int center = 0;
        //记录最长回文长度
        int longestHalf = 0;
        for (int i=0;i<length;i++){
            //是否需要中心扩展
            boolean needCalc = true;
            //如果此点在右边界的覆盖范围之内
            if (rightSide > i){
                //计算出rightCenter的对称位置
                int leftCenter = 2*rightCenter-i;
                //根据性质得到结论
                halfLenArr[i] = halfLenArr[leftCenter];
                //如果超过了右边界
                if (i+halfLenArr[i] > rightSide){
                    halfLenArr[i] = rightSide-i;
                }
                //未超过右边界，不需要扩展
                if (i+halfLenArr[leftCenter] < rightSide)
                    needCalc = false;
            }
            //需要中心扩展
            if (needCalc){
                while(i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < length) {
                    if(str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + halfLenArr[i];
                rightCenter = i;
                // 记录最长回文串
                if(halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(str.charAt(i));
        }
        return sb.length();
    }
    public static String preHandleString(String s){
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        sb.append("*");
        for (int i=0;i<len;i++){
            sb.append(s.charAt(i));
            sb.append("*");
        }
        return sb.toString();
    }
}

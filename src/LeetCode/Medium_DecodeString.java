package LeetCode;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 字符串copy
 * @author: wzh
 * @create: 2019-12-22 15:54
 **/
public class Medium_DecodeString {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
        String s1 = "30[a]2[bc]";
//        String s2 = "3[a2[c]]";
//        String s3 = "2[abc]3[cd]ef";
        System.out.println(decode(s1));
//        System.out.println(decode(s2));
//        System.out.println(decode(s3));
    }
    public static String decode(String s){
        String str = "";
        Stack<String> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch){
            if (c!=']'){
                stack.push(String.valueOf(c));
            }
            else {
                String str1 = "";
                while (!stack.empty() && !stack.peek().equals("[")){
                    str1 = stack.pop() + str1;
                }
                stack.pop();
                int num = 0;
                int a = 1;
                while (!stack.empty() && stack.peek().toCharArray()[0]-'0'>=0 && stack.peek().toCharArray()[0]-'0'<=9){
                    int n = stack.pop().toCharArray()[0]-'0';
                    num += n*a;
                    a *= 10;
                }
                String add_str = str1;
                while (num>1){
                    str1 += add_str;
                    num--;
                }
                stack.push(str1);
            }
        }
        while (!stack.empty())
            str = stack.pop()+str;
        return  str;
    }
    public static String decodeStringStack(String s){
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        int curNum = 0;
        while (idx<s.length()){
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(s.charAt(idx)))
                    curNum = 10 * curNum
                            + (s.charAt(idx++) - '0');
            } else if (ch == '[') {
                resStack.push(res);
                res = "";// 注意
                // 此push可以放在上面的while循环中
                countStack.push(curNum);
                curNum = 0;// 注意
                idx++;
                // 取出计算结果，和数字
            } else if (ch == ']') {
                StringBuilder temp =
                        new StringBuilder(resStack.pop());

                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;

                // 字母
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
    public static String decodeString(String s){
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        String str1 = "";
        int count = 0;
        for (char a : array){
            if (a==']' && !stack.empty()){
                count--;
                 str1 = "";
//                if (count==0)
//                    str1 = str;
                while (!stack.peek().equals("[")){
                    str1 = stack.pop() + str1;
                }
                stack.pop();
                int n = stack.pop().toCharArray()[0]-'0';
                String list_s = str1;
                while (n>1){
                    str1 = list_s + str1;
                    n--;
                }
                stack.push(str1);
//                str += str1;
            }
            else {
                stack.push(String.valueOf(a));
                if (a=='[')
                    count++;
            }
        }
        return str1;
    }
}

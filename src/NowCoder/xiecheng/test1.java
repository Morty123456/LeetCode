package NowCoder.xiecheng;


import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: wzh
 * @time: 2020/9/8 19:29
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mingan = sc.nextLine();
        String juzi = sc.nextLine();
        String tihuan = sc.nextLine();
        System.out.println(solution(mingan, juzi, tihuan));
    }
    public static String solution(String mingan, String juzi, String tihuan){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : mingan.toCharArray()){
            if (hashMap.containsKey(ch)){
                hashMap.put(ch, hashMap.get(ch)+1);
            }else
                hashMap.put(ch, 1);
        }
        StringBuffer sb = new StringBuffer();
        int len = mingan.length();

        StringBuffer sbNow = new StringBuffer();
        char[] jz = juzi.toCharArray();
        for (int i=0; i<juzi.length(); i++){
            if (isChar(jz[i])){
                sbNow.append(jz[i]);
                if (sbNow.length()==len){
                    if (i==juzi.length()-1){
                        if (isMinGan(sbNow.toString(), hashMap)){
                            sb.append(tihuan);
                        }
                        else{
                            sb.append(sbNow.toString());
                        }
                        sbNow = new StringBuffer();
                    }else if (!isChar(jz[i+1]) && isMinGan(sbNow.toString(), new HashMap<>(hashMap))){
                        sb.append(tihuan);
                        sbNow = new StringBuffer();
                    }
                }
            }else {
                sbNow.append(jz[i]);
                sb.append(sbNow.toString());
                sbNow = new StringBuffer();
            }
        }
        sb.append(sbNow.toString());
        return sb.toString();
    }
    public static boolean isChar(char ch){
        if ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
            return true;
        return false;
    }
    public static boolean isMinGan(String str1, HashMap<Character,Integer> hashMap){
        char[] chars = str1.toCharArray();
        for (char ch : chars){
            if (hashMap.containsKey(ch)){
                int num = hashMap.get(ch);
                if (num==0)
                    return false;
                hashMap.put(ch, num-1);
            }
            else
                return false;
        }
        return true;
    }
}

package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/6/24 8:39
 * @description:
 */
public class ex_58_reverseLeftWords {
    public static void main(String[] args){
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords(s, k));
    }
    public static String reverseLeftWords(String s, int n){
        StringBuilder sb = new StringBuilder();
        for (int i=n;i<s.length()+n;i++){
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }
}

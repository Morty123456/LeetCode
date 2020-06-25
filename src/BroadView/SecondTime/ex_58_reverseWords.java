package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/6/25 6:51
 * @description:
 */
public class ex_58_reverseWords {
    public static void main(String[] args){
        String s = "the sky is blue";
        String ss = "  a good   example. ";
        System.out.println(reverseWords(ss));
    }
    public static String reverseWords(String s){
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=str.length-1;i>=0;i--){
            if (!str[i].equals("")){
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}

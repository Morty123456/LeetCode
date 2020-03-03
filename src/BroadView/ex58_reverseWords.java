package BroadView;

public class ex58_reverseWords {
    public static void main(String[] args){
        String s = " ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        int length = str.length;
        for(int i=length-1;i>0;i--){
            if (str[i].length()>0){
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        sb.append(str[0]);
        return sb.toString().trim();
    }
}

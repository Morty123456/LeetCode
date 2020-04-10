package LeetCode;

public class Medium_reverseWords {
    public static void main(String[] args){
        String str = " the sky  is  blue  ";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s){
        String[] strArr = s.split(" ");
        int length = strArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i=length-1;i>=0;i--){
            if (!strArr[i].equals("")){
                sb.append(strArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}

package LeetCode;

public class Easy_compressString {
    public static void main(String[] args){
        String s = "aabbccdd";
        System.out.println(compressString(s));
    }
    public static String compressString(String s){
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        char ch = array[0];
        int count=1;
        for (int i=1;i<s.length();i++){
            if (array[i]==ch){
                count++;
            }
            else {
                sb.append(ch);
                sb.append(count);
                ch=array[i];
                count=1;
            }
        }
        sb.append(ch);
        sb.append(count);
        return sb.toString().length()<s.length() ? sb.toString() : s;
    }
}

package LeetCode;

public class Easy_countCharacters {
    public static void main(String[] args){
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
    public static int countCharacters(String[] words, String chars){
        char[] ch = chars.toCharArray();
        int count = 0;
        for (String str:words){
            char[] chClone = new char[ch.length];
            for (int i=0;i<ch.length;i++)
                chClone[i] = ch[i];
            if (findStr(str, chClone))
                count += str.length();
        }
        return count;
    }
    public static boolean findStr(String str, char[] ch){
        for (int i=0;i<str.length();i++){
            int j;
            for (j=0;j<ch.length;j++){
                if (str.charAt(i)==ch[j]){
                    ch[j]=' ';
                    break;
                }
            }
            if (j==ch.length)
                return false;
        }
        return true;
    }
}

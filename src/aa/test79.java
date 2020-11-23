package aa;

public class test79 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        for (char ch : t.toCharArray()){
            count[ch-'a']--;
        }
        for (int num : count){
            if (num!=0)
                return false;
        }
        return true;
    }
}

package LeetCode;

public class Medium_longestPalindrome {
    public static void main(String[] args){
        System.out.println(longestPalindrome("aaaabaaa"));
    }
    public static String longestPalindrome(String s){
        s = preHandleString(s);
        int length = s.length();
        int right = 0;
        int rightCenter = 0;
        int[] half = new int[length];
        int center = 0;
        int longest = 0;
        for (int i=0;i<length;i++){
            boolean need = true;
            if (right>i){
                int leftCenter = rightCenter-(i-rightCenter);
                half[i] = half[leftCenter];
                if (i+half[leftCenter]>=right){
                    half[i] = right-i;
                } else {
                    need=false;
                }
            }
            if (need){
                while (i-1-half[i]>=0 && i+1+half[i]<length){
                    if (s.charAt(i-1-half[i])==s.charAt(i+1+half[i])){
                        half[i]++;
                    }else
                        break;
                }
            }
            right = i+half[i];
            rightCenter = i;
            if (half[i]>longest){
                center = i;
                longest = half[i];
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i=center-longest+1;i<=center+longest;i+=2)
            sb.append(s.charAt(i));
        return sb.toString();
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

package LeetCode;

public class Hard_longestPalindrome {
    public static void main(String[] args){
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s){
        String str = preHandleString(s);
        int length = str.length();
        int rightSide = 0;
        int rightCenter = 0;
        int center = 0;
        int longestHalf = 0;
        int[] halfLenArr = new int[length];
        for (int i=0;i<length;i++){
            boolean needCalc = true;
            if (rightSide>i){
                int left = 2*rightCenter-i;
                halfLenArr[i] = halfLenArr[left];
                if (i+halfLenArr[i]>=rightSide){
                    halfLenArr[i] = rightSide-i;
                }
                if (i+halfLenArr[i]<rightSide)
                    needCalc=false;
            }
            if (needCalc){
                while (i-1-halfLenArr[i]>=0 && i+1+halfLenArr[i]<length){
                    if (str.charAt(i-1-halfLenArr[i])==str.charAt(i+1+halfLenArr[i]))
                        halfLenArr[i]++;
                    else
                        break;
                }
                rightSide = i+halfLenArr[i];
                rightCenter = i;
                if (halfLenArr[i]>longestHalf){
                    longestHalf=halfLenArr[i];
                    center=i;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i=center-longestHalf+1;i<=center+longestHalf;i+=2)
            sb.append(str.charAt(i));
        return sb.toString();
    }
    public static String preHandleString(String s){
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        sb.append("*");
        for (char ch : s.toCharArray()){
            sb.append(ch);
            sb.append("*");
        }
//        for (int i=0;i<len;i++){
//            sb.append(s.charAt(i));
//            sb.append("*");
//        }
        return sb.toString();
    }
}

package LeetCode;

public class Easy_longestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        if (strs.length==0)
            return "";
        return longestCommonPrefix(strs, 0, strs.length-1);
    }
    public static String longestCommonPrefix(String[] strs, int left, int right){
        if (left==right)
            return strs[left];
        else {
            int mid = (left+right)/2;
            String lcpLeft = longestCommonPrefix(strs, left, mid);
            String lcpRight = longestCommonPrefix(strs, mid+1, right);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    public static String commonPrefix(String left, String right){
        int minLength = left.length()<right.length() ? left.length() : right.length();
        for (int i=0;i<minLength;i++){
            if (right.charAt(i)!=left.charAt(i))
                return left.substring(0,i);
        }
        return left.substring(0, minLength);
    }
}

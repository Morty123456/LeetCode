package BroadView;

public class ex20_isNumber {
    public static void main(String[] args){
        String s = " 005047e+6";
        System.out.println(isNumber(s));
    }
    static int i=0;
    public static boolean isNumber(String s){
        s = s.trim();
        if (s==null || s.length()==0)
            return false;
        boolean A = scanInteger(s), B = false, C = false;
        if (i<s.length() && s.charAt(i)=='.'){
            i++;
            B =  scanUnsignedInteger(s);
        }
        if (i<s.length() && (s.charAt(i)=='e' || s.charAt(i)=='E')){
            i++;
            C = scanInteger(s);
            if (!C)
                return false;
        }
        return (i==s.length() && (A || B));
    }
    public static boolean scanInteger(String s){
        if (i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
            i++;
        return scanUnsignedInteger(s);
    }
    public static boolean scanUnsignedInteger(String s){
        int start = i;
        while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
            i++;
        return i>start;
    }
}

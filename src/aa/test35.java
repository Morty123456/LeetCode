package aa;

public class test35 {
    public static void main(String[] args) {
        String str1 = "733064366";
        String str2 = "459309139";
        System.out.println(solve(str1, str2));
    }
    public static String solve(String s, String t){
        StringBuilder sb = new StringBuilder();
        int sEnd = s.length()-1;
        int tEnd = t.length()-1;
        int overTen = 0;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        while (sEnd>=0 && tEnd>=0){
            int sInt = chs[sEnd]-'0';
            int tInt = cht[tEnd]-'0';
            int val = sInt + tInt + overTen;
            overTen = val/10;
            val = val%10;
            sEnd--;
            tEnd--;
            sb.append(val);
        }
        while (sEnd>=0){
            int sInt = chs[sEnd]-'0';
            int val = sInt + overTen;
            overTen = val/10;
            val = val%10;
            sEnd--;
            sb.append(val);
        }
        while (tEnd>=0){
            int tInt = cht[tEnd]-'0';
            int val = tInt + overTen;
            overTen = val/10;
            val = val%10;
            tEnd--;
            sb.append(val);
        }
        if (overTen>0)
            sb.append(overTen);

        return sb.reverse().toString();
    }
}

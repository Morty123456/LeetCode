package aa;

public class test80 {
    public static void main(String[] args) {
        System.out.println(trans(12258));
    }
    public static int trans(int num){
        String str = num+"";
        char[] chars = str.toCharArray();
        int[] count = new int[str.length()+1];
        count[0] = count[1] = 1;
        for (int i=2; i<=str.length(); i++){
            String s = chars[i-2]+""+chars[i-1];
            if (chars[i-2]=='0' || Integer.valueOf(s)>25){
                count[i] = count[i-1];
            }else
                count[i] = count[i-1]+count[i-2];
        }
        return count[str.length()];
    }
}

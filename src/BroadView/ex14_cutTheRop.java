package BroadView;
//除了dp，还可以找规律
//见leetcode解析
public class ex14_cutTheRop {
    public static void main(String[] args){
        int m = 8;
        int[] cut = new int[m+1];
        cut[2]=2;
        cut[3]=3;
        for (int i=4;i<=m;i++){
            for (int j=1;j<=i/2;j++){
                cut[i] = Math.max(cut[i], cut[j]*cut[i-j]);
            }
        }
        System.out.println(cut[m]);
    }
}

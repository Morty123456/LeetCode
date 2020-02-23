package BroadView;

public class ex15_binarySystem {
    public static void main(String[] args){
        System.out.println(hammingWeight(-9));
    }
    //java运算符
    //  >>右移运算
    //  >>>无符号运算右移，高位直接补0
    public static int hammingWeight(int n){
        int count=0;
        while (n!=0){
            count += n&1;
            n=n>>>1;
        }
        return count;
    }
}

package BroadView;

public class ex15_binarySystem {
    public static void main(String[] args){
        int n = -9;
//        System.out.println(hammingWeight_fast(n));
        System.out.println(hammingWeight_left(n));
//        System.out.println(hammingWeight(n));
    }
    //java运算符
    //  >>右移运算
    //  >>>无符号运算右移，高位直接补0
    //
    public static int hammingWeight_fast(int n){
        int count=0;
        while (n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
    //左移位，判断1的个数
    public static int hammingWeight_left(int n){
        int count=0;
        int flag=1;
        while (flag!=0){
//            System.out.println(Integer.toBinaryString(flag));
//            System.out.println(Integer.toBinaryString(n));
//            System.out.println(2&2);
            if((flag&n)!=0)
                count++;
            flag = flag<<1;
        }
        return count;
    }
    //右移位，判断1的个数
    public static int hammingWeight(int n){
        int count=0;
        while (n!=0){
            count += n&1;
            n=n>>>1;
        }
        return count;
    }
}

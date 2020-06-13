package BroadView.SecondTime;

public class hammingWeight {
    public static void main(String[] args){
        System.out.println(hammingWeight(9));
    }
    public static int hammingWeight(int n){
        int a = 1;
        int count = 0;
        //a左移
        for (int i=0;i<32;i++){
            if ((n&a)!=0){
                count++;
            }
//            System.out.println(a);
            a = a<<1;
        }
        //n右移
//        while (n!=0){
//            count += n&1;
//            n >>>= 1;
//        }
        return count;
    }
}

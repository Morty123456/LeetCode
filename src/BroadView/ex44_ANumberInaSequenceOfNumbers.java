package BroadView;

public class ex44_ANumberInaSequenceOfNumbers {
    public static void main(String[] args){
        System.out.println(findNthDigit(2147483647));
    }
    public static int findNthDigit(int n){
        if (n==0)
            return 0;
        long begin = 1;
        long pre = 1;
        while (n - pre*9*begin > 0){
            n -= pre*9*begin;
            begin++;
            pre *= 10;
        }
        System.out.println(begin);
        long count = n/begin;
        int yushu = (int)(n%begin);
        if(yushu==0){
            return (int)(pre+count-1)%10;
        }
        else {
            long num = pre+count;
            System.out.println(num);
            String str = Long.toString(num);
            char ch = str.charAt(yushu-1);
            return ch-'0';
        }
    }
}

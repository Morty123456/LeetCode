package BroadView.SecondTime;

public class numWays {
    public static void main(String[] args){
        System.out.println(numWays(7));
    }
    public static int numWays(int n){
        if (n==1 || n==0)
            return 1;
        if (n==2)
            return 2;
        int a = 1, b = 2;
        int c = 0;
        while (n-->2){
            c = (a+b)%1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}

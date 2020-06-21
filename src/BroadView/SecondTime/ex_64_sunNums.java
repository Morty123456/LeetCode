package BroadView.SecondTime;

public class ex_64_sunNums {
    public static void main(String[] args){
        System.out.print(sumNums(3));
    }
    static int res = 0;
    public static int sumNums(int n){
        boolean x = n>1 && sumNums(n-1)>0;
        res += n;
        return res;
    }
}

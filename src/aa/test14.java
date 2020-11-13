package aa;

public class test14 {
    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }
    public static int reverse (int x) {
        // write code here
        int sum= 0;
        int max = Integer.MAX_VALUE/10;
        while(x!=0){
            int n = x%10;
            x /= 10;
            sum = sum*10 + n;
            if(sum>max){
                return 0;
            }
            if(sum==max){
                if(x>7 || x<-8){
                    return 0;
                }else if(x>=0){
                    return sum*10+x;
                }else{
                    return sum*10*-1+x;
                }
            }
        }
        return sum;
    }
}

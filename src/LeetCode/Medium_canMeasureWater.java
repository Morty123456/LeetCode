package LeetCode;

public class Medium_canMeasureWater {
    public static void main(String[] args){
//        System.out.println(canMeasureWater2(3,5,4));
        System.out.println(canMeasureWater2(0,0,5));
    }
    public static boolean canMeasureWater2(int x, int y, int z){
        if (x+y<z)
            return false;
        if (x==0 || y==0)
            return z==0 || x+y==z;
        return z%gcd(x,y)==0;
    }
    public static int gcd(int x, int y){
        if(x>y)
            x = x+y-(x=y);
        while (y%x!=0){
            y=y%x;
            x = x+y-(y=x);
        }
        return x;
    }
    public static boolean canMeasureWater(int x, int y, int z){
        if (z==0)
            return true;
        if (x==0)
            return z%y==0;
        if (y==0)
            return z%x==0;
        if (x>y)
            x = x+y-(y=x);
        int c = y-x;
        for (int i=0;i<=z/x;i++){
            for (int j=0;j<=z/y;j++){
                for (int k=0;k<=z/c;k++){
                    if (i*x+j*y+k*c==z)
                        return true;
                }
            }
        }
        return false;
    }
}

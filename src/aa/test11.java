package aa;

public class test11 {
    public static void main(String[] args) {
        System.out.println(ft(2));
    }
    public static int ft(int t){
        try{
            t = t*t;
            return t;
        }finally {
            t = 2;
            return t;
        }
    }
}

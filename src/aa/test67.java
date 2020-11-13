package aa;

public class test67 {
    public static void main(String[] args) {
        int[] a = {2,3,1,1,4,0,0,4,3,3};
        a = sortArrayByParityII(a);
        for (int aa : a)
            System.out.print(aa+" ");
    }
    public static int[] sortArrayByParityII(int[] A) {
        int left = 1;
        int right = (A.length-1)/2*2;
        while(right>=0){
            while(left<A.length && A[left]%2 == left%2){
                left+=2;
            }
            while (right>=0 && A[right]%2 == right%2){
                right-=2;
            }
            if (left<A.length && right>=0)
                A[left] = A[left]+A[right]-(A[right]=A[left]);
        }
        return A;
    }
}

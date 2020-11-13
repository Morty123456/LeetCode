package aa;

public class test57 {
    public static void main(String[] args) {
        int[] A = {1, 2};
        System.out.println(validMountainArray(A));
    }
    public static boolean validMountainArray(int[] A) {
        int left = 0, right = A.length-1;
        while (left+1 < A.length){
            if (A[left+1] > A[left])
                left++;
            else
                break;
        }
        while (right-1 >=0){
            if (A[right-1] > A[right])
                right--;
            else
                break;
        }
        return left==right && left!=0 && right!=A.length-1;
    }
}

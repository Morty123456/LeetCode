package aa;

public class test76 {
    public static void main(String[] args) {
        int[] num = {1};
        moveZero(num);
        for (int n : num)
            System.out.print(n+" ");
    }
    public static void moveZero(int[] nums){
        int moveLength = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0)
                moveLength++;
            else if (moveLength>0){
                nums[i-moveLength]=nums[i];
                nums[i] = 0;
            }
        }
    }
}

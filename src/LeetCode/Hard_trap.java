package LeetCode;

public class Hard_trap {
    public static void main(String[] args){
        int[] heigth = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heigth));
    }
    public static int trap(int[] height){
        int[] maxRight = new int[height.length];
        int rightHeight = height[height.length-1];
        for (int i=height.length-1;i>=0;i--){
            if (height[i]>=rightHeight){
                rightHeight = height[i];
            }
            maxRight[i] = rightHeight;
        }
        int leftHeight = 0;
        int sumRain = 0;
        for (int i=0;i<height.length;i++){
            leftHeight = leftHeight>height[i] ? leftHeight:height[i];
            sumRain += (leftHeight-height[i]) >(maxRight[i]-height[i]) ? (maxRight[i]-height[i]) : (leftHeight-height[i]);
        }
        return sumRain;
    }
}

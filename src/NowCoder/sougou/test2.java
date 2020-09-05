package NowCoder.sougou;

/**
 * @author: wzh
 * @time: 2020/9/5 18:31
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        int t = 10;
        int[] xa = {-1,2,2,2,7,2};
        System.out.println(getHouse(t, xa));
    }
    public static int getHouse(int t, int[] xa){
        int left = 0;
        int right = 2;
        int sum = 0;
        while (right<xa.length){
            float leftSide = xa[left] + (float)(xa[left+1]/2);
            float rightSide = xa[right] - (float)(xa[right+1]/2);
            if (rightSide - leftSide == (float) (t)){
                sum++;
            }else if (rightSide - leftSide > (float) (t)){
                sum += 2;
            }
            left+=2;
            right+=2;
        }
        sum += 2;
        return sum;
    }
}

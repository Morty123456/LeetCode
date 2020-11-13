package aa;

import java.util.Scanner;

public class test63 {
    public static void main(String[] args) {
        int[] num = {6,0,8,2,1,5};
        int[] num2 = {1,2,3,4,5};
        System.out.println(solution(num));
    }
    public static int solution(int[] num){
        int[] leftMin = new int[num.length];
        int cur_min_post = 0;
        for (int i=0; i<num.length; i++){
            if (num[i]<num[cur_min_post]){
                cur_min_post = i;
            }
            leftMin[i] = cur_min_post;
        }
        int maxLength = 0;
        for (int i=num.length-1, j=num.length-1; i>=0;){
            i = leftMin[i];
            if (num[j] >= num[i]){
                if (j-i > maxLength)
                    maxLength = j-i;
                --i;
            }else
                --j;
        }
        return maxLength;
    }
}

package BroadView.SecondTime;

import java.util.LinkedList;

/**
 * @author: wzh
 * @time: 2020/6/25 14:11
 * @description:
 */
public class ex_57_findContinuousSequence {
    public static void main(String[] args){
        int[][] res = findContinuousSequence(15);
        for (int[] aa : res){
            for (int a : aa){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public static int[][] findContinuousSequence(int target){
        int left = 1, right = 2;
        LinkedList<int[]> lists = new LinkedList<>();
        int sum = left+right;
        while(left<=target/2){
            while (sum<target){
                right++;
                sum += right;
            }
            while (sum>target){
                sum -= left;
                left++;
            }
            if (sum==target){
                int[] num = new int[right-left+1];
                for (int j=left;j<=right;j++)
                    num[j-left]=j;
                lists.add(num);
                right++;
                sum += right;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}

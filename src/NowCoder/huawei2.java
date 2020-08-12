package NowCoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/8/12 18:49
 * @description:
 */
public class huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        int row = sc.nextInt(), col = sc.nextInt();
        int[][] nums = new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(goThrough(step, nums, row, col));
    }
    public static int goThrough(int step, int[][] nums, int row, int col){
        Stack<Integer> stack = new Stack<>();
        int[][] local = {{step,0},{-step,0},{0,step},{0,-step}};
        stack.push(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int y = stack.pop();
            int x = stack.pop();
            for (int[] l : local){
                int xNow = x + l[0];
                int yNow = y + l[1];
                if (xNow>=0 && xNow<row && yNow>=0 && yNow<col && nums[xNow][yNow]==1){
                    if (xNow==row-1 && yNow==col-1)
                        return 1;
                    else {
                        nums[xNow][yNow] = 0;
                        stack.push(xNow);
                        stack.push(yNow);
                    }
                }
            }
        }
        return 0;
    }
}

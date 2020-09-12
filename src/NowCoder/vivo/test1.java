package NowCoder.vivo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: wzh
 * @time: 2020/9/12 20:21
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] chars = new char[n][n];
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        for (int i=0;i<n;i++){
            String s = sc.nextLine();
            chars[i] = s.toCharArray();
        }
        int[] start = new int[2];
        start[0] = x1;
        start[1] = y2;
        int[] end = new int[2];
        end[0] = x2;
        end[1] = y2;
        System.out.println(solution(chars, start, end));
    }
    public static int solution(char[][] chars, int[] start, int[] end){
        int[][] fx = {{1,0},{-1,0},{0,-1},{0,1}};
        Stack<int[]> stack = new Stack<>();
        int len = chars.length;
        boolean[][] visited = new boolean[len][len];
        int x = start[0];
        int y = start[1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        int sum = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            int[][] lo = {{1,0},{-1,0},{0,-1},{0,1}};
            while (size-- > 0){
                int xNow = queue.poll();
                int yNow = queue.poll();
            }

        }
        return -1;
    }
}

package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/12 14:14
 * @description:
 */
public class Medium_findWhetherExistsPath {
    public static void main(String[] args) {
        int n = 3;
        int[][] graph = {
                {0,1},{0,2},{1,2},{1,2}
        };
        int start = 0, target = 2;
        System.out.println(solution(n, graph, start, target));
    }
    public static boolean solution(int n, int[][] graph, int start, int target){
        List<Integer>[] lists = getLists(n, graph);
        boolean[] visited = new boolean[n];
        return go(lists, start, target, visited);
    }
    public static List<Integer>[] getLists(int n, int[][] graph){
        List<Integer>[] lists = (List<Integer>[]) new List[n];
        for (int i=0;i<n;i++)
            lists[i] = new LinkedList<>();
        for (int[] num : graph){
            lists[num[0]].add(num[1]);
        }
        return lists;
    }
    public static boolean go(List<Integer>[] lists, int start, int target, boolean[] visited){
        if (start==target)
            return true;
        else {
            List<Integer> list = lists[start];
            visited[start] = true;
            for (int num : list){
                if (!visited[num] && go(lists, num, target, visited))
                    return true;
            }
            return false;
        }
    }
}

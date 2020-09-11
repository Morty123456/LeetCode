package LeetCode;

/**
 * @author: wzh
 * @time: 2020/9/10 22:13
 * @description:
 */
public class Medium_canReach {
    public static void main(String[] args) {
        int[] num = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(num, start));
    }
    static boolean[] visited;
    public static boolean canReach(int[] arr, int start){
        visited = new boolean[arr.length];
        boolean f = dfs(arr, start);
        return f;
    }
    public static boolean dfs(int[] arr, int local){
        if (local>=arr.length || local<0 || visited[local])
            return false;
        visited[local] = true;
        return arr[local]==0 || dfs(arr, local-arr[local]) || dfs(arr, local+arr[local]);
    }
}

package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/16 15:05
 * @description:
 */
public class Medium_isBipartite {
    public static void main(String[] args){
        int[][] num = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(num));
    }
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    static int[] color;
    static boolean judge;
    public static boolean isBipartite(int[][] graph){
        int n = graph.length;
        color = new int[n];
        judge = true;
        for (int i=0;i<n && judge;i++){
            if (color[i]==UNCOLORED)
                dfs(i, RED, graph);
        }
        return judge;
    }
    public static void dfs(int i, int col, int[][] graph){
        if (!judge)
            return;
        color[i] = col;
        int colNext = col==RED?GREEN:RED;
        for (int node : graph[i]){
            if (color[node]==UNCOLORED){
                dfs(node, colNext, graph);
            }else if (color[node]!=colNext){
                judge=false;
                return;
            }
        }
    }
}

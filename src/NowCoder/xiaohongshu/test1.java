package NowCoder.xiaohongshu;

/**
 * @author: wzh
 * @time: 2020/9/6 18:51
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        int[][] num = {{3,1,4},{5,8,10}};
        System.out.println(find(num));
    }
    public static int find(int[][] num){
        int row = num.length;
        int col = num[0].length;
        boolean[] visited = new boolean[row*col+1];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int a = num[i][j];
                if (a<visited.length){
                    visited[a] = true;
                }
            }
        }
        for (int i=1;i<visited.length;i++){
            if (!visited[i]){
                return i;
            }
        }
        return row*col+1;
    }
}

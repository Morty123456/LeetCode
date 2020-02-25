package BroadView;

public class ex29_PrintMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] spir = spiralOrder(matrix);
        for (int a: spir)
            System.out.print(a+" ");
    }
    public static int[] spiralOrder(int[][] matrix){
        int row = matrix.length;
        if(row==0)
            return new int[0];
        int col = matrix[0].length;
        int[] spiral = new int[row*col];
        boolean[][] visited = new boolean[row][col];
        int start=0;
        int startx=0, starty=0;
        while(start<spiral.length){
            while(starty<col && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx][starty++];
            }

            while(startx<row && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx++][starty];
            }
//            startx--;
            while(starty>=0 && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx][starty--];
            }
//            starty++;
            while(visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx--][starty];
            }
//            startx++;
        }
        return spiral;
    }
}

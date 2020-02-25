package BroadView;

public class ex29_PrintMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = {{1,2},{3,4}};
//        int[][] matrix = {{1}};
//        int[] spir = spiralOrder(matrix);
//        for (int a: spir)
//            System.out.print(a+" ");
        PrintMatrixClockwisely(matrix, matrix[0].length, matrix.length);
    }
    //官方解法
    public static void PrintMatrixClockwisely(int[][] matrix, int columns, int rows){
        if (matrix.length==0 || columns<=0 || rows<=0)
            return;
        int start = 0;
        while (columns>start*2 && rows>start*2){
            PrintMatrixInCircle(matrix, columns, rows, start);
            start++;
        }
    }
    public static void PrintMatrixInCircle(int[][] numbers, int columns, int rows, int start){
        int endX = columns-1-start;
        int endY = rows-1-start;
        for (int i=start;i<=endX;++i){
            int number = numbers[start][i];
            System.out.print(number+" ");
        }
        if(start<endY){
            for (int i=start+1;i<=endY;++i){
                int number = numbers[i][endX];
                System.out.print(number+" ");
            }
        }
        if (start<endX && start<endY){
            for (int i=endX-1;i>=start;--i){
                int number = numbers[endY][i];
                System.out.print(number+" ");
            }
        }
        if (start<endX && start<endY-1){
            for (int i=endY-1;i>=start+1;--i){
                int number = numbers[i][start];
                System.out.print(number+" ");
            }
        }
    }
    //定义一个数组保存已访问过的部分
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
            startx++;
            starty--;
            while(startx<row && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx++][starty];
            }
            startx--;
            starty--;
            while(starty>=0 && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx][starty--];
            }
            startx--;
            starty++;
            while(startx>=0 && visited[startx][starty]==false){
                visited[startx][starty]=true;
                spiral[start++]=matrix[startx--][starty];
            }
            startx++;
            starty++;
        }
        return spiral;
    }
}

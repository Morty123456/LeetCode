package BroadView;

public class ex12_RoadInMatrix {
    public static void main(String[] args){
        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "abcced";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;
        char[] strWord = word.toCharArray();
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (hasPath(board, visited, row, col, i, j, count, strWord)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPath(char[][] board, boolean[][] visited, int row, int col, int nowRow, int nowCol, int count, char[] strWord){
        boolean hasPath = false;
        if (nowRow>=0 && nowRow<row && nowCol>=0 && nowCol<col && board[nowRow][nowCol]==strWord[count] && visited[nowRow][nowCol]==false){
//            System.out.println(board[nowRow][nowCol]+" "+strWord[count]);
            if (count==strWord.length-1)
                return true;
            count++;
            visited[nowRow][nowCol]=true;
            hasPath = hasPath(board, visited, row, col, nowRow-1, nowCol, count, strWord)
                    || hasPath(board, visited, row, col, nowRow+1, nowCol, count, strWord)
                    || hasPath(board, visited, row, col, nowRow, nowCol-1, count, strWord)
                    || hasPath(board, visited, row, col, nowRow, nowCol+1, count, strWord);
            if (!hasPath){
                count--;
                visited[nowRow][nowCol]=false;
            }
        }
        return hasPath;
    }
}

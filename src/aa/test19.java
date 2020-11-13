package aa;

import java.util.ArrayList;

public class test19 {
    public static void main(String[] args) {
        int[][] nums = {{2,3}};
        ArrayList<Integer> arrayList = spiralOrder(nums);
        for (int a : arrayList)
            System.out.print(a+"");
    }
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        while(left<=right && up<=down){
            for(int i=left; i<=right; i++){
                list.add(matrix[up][i]);
            }
            up++;
            for(int i=up; i<=down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(down>=up){
                for(int i=right; i>=left ;i--){
                    list.add(matrix[down][i]);
                }
            }
            down--;
            if(right>=left){
                for(int i=down; i>=up; i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }
}

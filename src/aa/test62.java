package aa;

public class test62 {
    public static void main(String[] args) {
        int[][] points= {{3,3},{5,-1},{-2,4}};
        int[][] res = kClosest(points, 2);
        for (int[] r : res){
            System.out.println(r[0]+" "+r[1]);
        }
    }
    public static int[][] kClosest(int[][] points, int k){
        int[][] res = new int[k][2];
        for (int i=0; i<k; i++){
            res[i] = points[i];
        }
        for (int i=res.length/2; i>=0; i--){
            sort(res, i);
        }
        for (int i=k; i<points.length; i++){
            if (res[0][0]*res[0][0]+res[0][1]*res[0][1] > points[i][0]*points[i][0]+points[i][1]*points[i][1]){
                res[0] = points[i];
                sort(res, 0);
            }
        }
        return res;
    }
    public static void sort(int[][] res, int start){
        int[] ch = res[start];
        for (int i=start*2+1; i<res.length; i=start*2+1){
            if (i+1<res.length && (res[i][0]*res[i][0]+res[i][1]*res[i][1])<(res[i+1][0]*res[i+1][0]+res[i+1][1]*res[i+1][1])){
                i++;
            }
            if (res[i][0]*res[i][0]+res[i][1]*res[i][1] > ch[0]*ch[0]+ch[1]*ch[1]){
                res[start] = res[i];
                start = i;
            }else {
                break;
            }
        }
        res[start] = ch;
    }
}

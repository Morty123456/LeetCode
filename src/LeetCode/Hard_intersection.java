package LeetCode;

public class Hard_intersection {
    public static void main(String[] args) {
//        int[] start1 = {0, 0};
//        int[] end1 = {1, 0};
//        int[] start2 = {1, 1};
//        int[] end2 = {0, -1};
        int[] start1 = {0, 0};
        int[] end1 = {0, 3};
        int[] start2 = {1, 1};
        int[] end2 = {1, 0};
//        int[] start1 = {0, 0};
//        int[] end1 = {0, 1};
//        int[] start2 = {1, 0};
//        int[] end2 = {1, 1};
        double[] res = intersection(start1, end1, start2, end2);
        System.out.println(res[0]+"    "+res[1]);
    }
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];
        double[] res = new double[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        //是否平行
        if((y4-y3)*(x2-x1)==(y2-y1)*(x4-x3)){
            //是否在同一条直线
            if ((y2-y1)*(x3-x1)==(y3-y1)*(x2-x1)){
                if (inside(x1,y1,x2,y2,x3,y3)){
                    update(res, (double)x3, (double)y3);
                }
                if (inside(x1,y1,x2,y2,x4,y4)){
                    update(res, (double)x4, (double)y4);
                }
                if (inside(x3,y3,x4,y4,x1,y1)){
                    update(res, (double)x1, (double)y1);
                }
                if (inside(x3,y3,x4,y4,x2,y2)){
                    update(res, (double)x2, (double)y2);
                }
            }
        }
        else {
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                res[0] = x1 + t1 * (x2 - x1);
                res[1] = y1 + t1 * (y2 - y1);
            }
        }
        if (res[0]==Integer.MAX_VALUE)
            return new double[0];
        return res;
    }
    public static boolean inside(int x1, int y1, int x2, int y2, int xk, int yk){
        return (x1==x2 || (Math.min(x1,x2)<=xk && xk<=Math.max(x1,x2))) && (y1==y2 || (Math.min(y1,y2)<=yk && yk<=Math.max(y1,y2)));
    }
    public static void update(double[] res, double xk, double yk){
        if (xk<res[0] || (xk==res[0] && yk<res[1])){
            res[0]=xk;
            res[1]=yk;
        }
    }
}

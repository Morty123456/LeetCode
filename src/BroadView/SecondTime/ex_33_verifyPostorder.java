package BroadView.SecondTime;

/**
 * @author: wzh
 * @time: 2020/6/29 20:06
 * @description:
 */
public class ex_33_verifyPostorder {
    public static void main(String[] args){
        int[] num = {1,6,3,2,5};
        int[] num1 = {1,3,2,6,5};
        System.out.println(verifyPostorder(num1));
    }
    public static boolean verifyPostorder(int[] postorder){
        return judge(postorder, 0, postorder.length-1);
    }
    public static boolean judge(int[] pos, int left, int right){
        if (left>=right)
            return true;
        int root = left;
        while (pos[root]<pos[right])
            root++;
        int m = root;
        while (pos[root]>pos[right])
            root++;
        return root==right && judge(pos, left, m-1) && judge(pos, m, right-1);
    }
}

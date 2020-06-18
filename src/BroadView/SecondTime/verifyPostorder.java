package BroadView.SecondTime;

public class verifyPostorder {
    public static void main(String[] args){
        int[] num = {1,3,2,6,5};
        System.out.println(verifyPostorder(num));
    }
    public static boolean verifyPostorder(int[] postorder){
        return verifyPostorder(postorder, 0, postorder.length-1);
    }
    public static boolean verifyPostorder(int[] postorder, int begin, int end){
        if (begin>=end)
            return true;
        int p = begin;
        //左边的都小于root
        while (postorder[p]<postorder[end]){
            p++;
        }
        //右边的都大于root
        int m = p;
        while (postorder[p]>postorder[end]){
            p++;
        }
        return p==end && verifyPostorder(postorder, begin, m-1) && verifyPostorder(postorder, m, end-1);
    }
}

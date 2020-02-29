package BroadView;

public class ex33_judgeBinarySearchTree {
    public static void main(String[] args){
//        int[] poster = {179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195, 15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471, 31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942, 37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013, 49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478, 62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667, 69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334, 80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655, 98675, 97001, 72112};
        int[] poster = {7,4,6,5};
        System.out.println(verifyPostorder(poster));
        System.out.println(verify(poster));
    }
    //参考的答案
    public static boolean verify(int[] postorder){
        if (postorder.length<=2)
            return true;
        return verify(postorder, 0, postorder.length-1);
    }
    public static boolean verify(int[] postorder, int start, int end){
        if(start>=end)
            return true;
        int i;
        for (i=start;i<end;i++){
            if (postorder[i]>postorder[end])
                break;
        }
        for (int j=i;j<end;j++){
            if (postorder[j] <= postorder[end])
                return false;
        }
        return verify(postorder, start, i-1) && verify(postorder, i, end-1);
    }
    //自己写的超时，还繁琐
    public static boolean verifyPostorder(int[] postorder){
        return verifyPostorder(postorder, 0, postorder.length-1);
    }
    public static boolean verifyPostorder(int[] postorder, int begin, int end){
        if (begin>=end)
            return true;
        int rootVal = postorder[end];
        int rightLocal = end;
        for (int i=begin;i<end;i++){
            if (postorder[i]>rootVal){
                rightLocal=i;
                break;
            }
        }
        for (int i=rightLocal;i<end;i++){
            if (postorder[i]<=rootVal)
                return false;
        }
        return verifyPostorder(postorder, begin, rightLocal-1) && verifyPostorder(postorder, rightLocal,end-1);
    }
}

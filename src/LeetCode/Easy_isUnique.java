package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/15 21:39
 * @description:
 */
public class Easy_isUnique {
    public static void main(String[] args){

    }
    public static boolean isUnique(String str){
        int mark = 0;
        for (char ch : str.toCharArray()){
            if ((mark & (1<<(ch-'a'))) !=0)
                return false;
            mark |= 1<<(ch-'a');
        }
        return true;
    }
}

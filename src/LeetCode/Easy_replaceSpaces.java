package LeetCode;

/**
 * @author: wzh
 * @time: 2020/7/16 14:23
 * @description:
 */
public class Easy_replaceSpaces {
    public static void main(String[] args){
        String s = "Mr John Smith    ";
        int length = 13;
        System.out.println(replaceSpaces(s, length));
    }
    public static String replaceSpaces(String S , int length){
        char[] chArr = S.toCharArray();
        int count = 0;
        for (int i=0;i<length;i++){
            if (chArr[i]==' ')
                count++;
        }
        int end = length+count*2-1;
        int i=length-1;
        while (i>=0){
            if (chArr[i]==' '){
                chArr[end--]='0';
                chArr[end--]='2';
                chArr[end--]='%';
            }else {
                chArr[end--]=chArr[i];
            }
            i--;
        }
        return String.valueOf(chArr).trim();
    }
}

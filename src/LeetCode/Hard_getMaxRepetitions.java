package LeetCode;

public class Hard_getMaxRepetitions {
    public static void main(String[] args){
        String s1="acb"; int n1 = 4;
        String s2="ab"; int n2 = 2;
        System.out.println(getMaxRepetitions(s1,n1,s2,n2));
    }
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2){
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        int index = 0;
        int local1 = 0;
        int local2 = 0;
        while (local1<n1){
            for(int i=0;i<charArray1.length;i++){
                if (charArray1[i]==charArray2[index]){
                    if (index==charArray2.length-1){
                        index=0;
                        local2++;
                    }
                    else
                        index++;
                }
            }
            local1++;
        }
        return local2/n2;
    }
}

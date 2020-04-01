package LeetCode;

public class Medium_maxDepthAfterSplit {
    public static void main(String[] args){
        String str = "()(())()";
        int[] num = maxDepthAfterSplit(str);
        for (int n : num)
            System.out.print(n+" ");
    }
    public static int[] maxDepthAfterSplit(String seq){
        int[] ans = new int[seq.length()];
        int count = 0;
        int i = 0;
        for (char ch : seq.toCharArray()){
            if (ch=='(')
                count++;
            if ((count&1)==1)
                ans[i]=0;
            if ((count&1)==0)
                ans[i]=1;
            if (ch==')')
                count--;
            i++;
        }
        return ans;
    }
}

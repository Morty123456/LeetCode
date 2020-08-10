package LeetCode.dp;

/**
 * @author: wzh
 * @time: 2020/8/10 6:56
 * @description:
 */
public class longestValidParentheses {
    public static void main(String[] args){
        String s = "(()())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s){
        int[] dp = new int[s.length()+1];
        char[] arr = s.toCharArray();
        int maxVal = 0;
//        for(int i=2;i<=arr.length;i++){
//            if(arr[i-1]==')' && arr[i-2]=='('){
//                dp[i] = dp[i-2] + 2;
//            }else if(arr[i-1]==')' && arr[i-2]==')' && i-dp[i-1]-2>=0 && arr[i-dp[i-1]-2] == '('){
//                dp[i] = dp[i-dp[i-1]-2] + dp[i-1] +2;
//            }
//            maxVal = Math.max(maxVal, dp[i]);
//        }
        for(int i=1;i<arr.length;i++){
            //如果 i 为 ) , i-1 为 ( , 那么 dp[i] 的长度 就是 i-2 位置的长度 + 2
            if(arr[i]==')' && arr[i-1]=='('){
                if (i-2<0)
                    dp[i]=2;
                else
                    dp[i] = dp[i-2] + 2;
            }
            //如果 i 和 i-1 位置都为 ），那么要判断 i-1对应的（ 的前一位是否也是 （
            //如果是，此位置长度 = i-1位置长度 + 2 + (此位置对应 ( 之前的长度)
            else if(arr[i]==')' && arr[i-1]==')' && i-dp[i-1]-1>=0 && arr[i-dp[i-1]-1] == '('){
                if (i-dp[i-1]-2>=0)
                    dp[i] = dp[i-dp[i-1]-2] + dp[i-1] +2;
                else
                    dp[i] = dp[i-1] + 2;
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}

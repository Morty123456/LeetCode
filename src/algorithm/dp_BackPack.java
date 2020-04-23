package algorithm;

public class dp_BackPack {
    public static void main(String[] args){
        int[] value = {0,6,3,5,4,9};
        int[] weight = {0,2,2,6,5,4};
        int space= 10;
//        System.out.print(ZeroOneBackPack(value, weight, space));
//        System.out.print(ZeroOneBackPackSpaceComplexity(value, weight, space));
        CompleteBackpack(value, weight, space);
        CompleteBackpackBeter(value, weight, space);
    }
    //01背包问题，每个物品只有一个
    public static int ZeroOneBackPack(int[] value, int[] weight, int space){
        int length = value.length;
        int[][] dp = new int[length][space+1];
        for (int i=1;i<length;i++){
            for (int j=1;j<=space;j++){
                if (weight[i]>j)
                    dp[i][j]=dp[i-1][j];
                else{
                    //第i件物品是否放入背包，是选择的条件
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        return dp[length-1][space];
    }
    public static int ZeroOneBackPackSpaceComplexity(int[] value, int[] weight, int space){
        int length = value.length;
        int[] dp = new int[space+1];
        for (int i=1;i<length;i++){
            for (int j=space;j>=weight[i];j--)
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
        }
        return dp[space];
    }
    //完全背包问题
    public static void CompleteBackpack(int[] value, int[] weight, int space){
        int length = value.length;
        int[][] dp = new int[length][space+1];
        for (int i=1;i<length;i++){
            for (int j=1;j<=space;j++){
                int k = j/weight[i];
                for (int z=0;z<=k;z++){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*weight[i]]+k*value[i]);
                }
            }
        }
        System.out.println(dp[length-1][space]);
    }
    public static void CompleteBackpackBeter(int[] value, int[] weight, int space){
        int length = value.length;
        int[] dp = new int[space+1];
        for (int i=1;i<length;i++){
            for (int j=weight[i];j<=space;j++)
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
        }
        System.out.println(dp[space]);
    }
}

package LeetCode;

public class Hard_maxProfit {
    public static void main(String[] args){
        int[] money = {5,4,3,2,1};
        System.out.println(maxProfit(money));
    }
    public static int maxProfit(int[] prices){
        int money = 0;
        for(int i=0;i<prices.length;i++){
            int nowMoney = 0;
            nowMoney += findMoney(prices,0,i)+findMoney(prices, i+1,prices.length-1);
            money = money < nowMoney ? nowMoney : money;
        }
        return money;
    }
    public static int findMoney(int[] prices, int begin, int end){
        if (begin>=prices.length)
            return 0;
        int money = 0;
        int min = prices[begin];
        int max = prices[begin];
        for(int i=begin;i<=end;i++){
            if(prices[i]>max){
                max = prices[i];
            }
            if (prices[i]<min){
                min = prices[i];
                max = prices[i];
            }
            money = Math.max(money, max-min);
        }
        return money;
    }
}

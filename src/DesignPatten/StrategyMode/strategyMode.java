package DesignPatten.StrategyMode;

public class strategyMode {
    public static void main(String[] args){
        String str = "满300-100";
        CashContext cs = new CashContext(str);
        System.out.println(cs.GetResult(300));
    }
}

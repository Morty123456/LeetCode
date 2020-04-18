package DesignPatten.StrategyMode;

public class CashContext {
    private CashSuper cs;
    public CashContext(String type){
        switch (type){
            case "正常收费":
                CashNormal cs0 = new CashNormal();
                cs = cs0;
                break;
            case "满300-100":
                CashReturn cs1 = new CashReturn(300,100);
                cs = cs1;
                break;
            case "打八折":
                CashRebate cs2 = new CashRebate(0.8);
                cs = cs2;
                break;
        }
    }
    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}

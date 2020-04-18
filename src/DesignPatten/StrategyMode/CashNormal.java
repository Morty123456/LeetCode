package DesignPatten.StrategyMode;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money){
        return money;
    }
}

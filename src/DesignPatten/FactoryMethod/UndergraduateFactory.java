package DesignPatten.FactoryMethod;

public class UndergraduateFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng(){
        return new Undergraduate();
    }
}

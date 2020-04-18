package DesignPatten.ProxyMethod;

public class Proxy implements GiveGift {
    Pursuit gg;
    public Proxy(String name){
        gg = new Pursuit(name);
    }
    public void giveDolls(){
        gg.giveDolls();
    }
    public void giveFlowers(){
        gg.giveFlowers();
    }
    public void giveChocolate(){
        gg.giveChocolate();
    }
}

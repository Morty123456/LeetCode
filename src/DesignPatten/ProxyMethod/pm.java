package DesignPatten.ProxyMethod;

public class pm {
    public static void main(String[] args){
        Proxy daili = new Proxy("jiaojiao");
        daili.giveChocolate();
        daili.giveDolls();
        daili.giveFlowers();
    }
}

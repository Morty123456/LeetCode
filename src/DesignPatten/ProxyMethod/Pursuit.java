package DesignPatten.ProxyMethod;

public class Pursuit implements GiveGift {
    String mm;
    public Pursuit(String mm){
        this.mm = mm;
    }
    public void giveFlowers(){
        System.out.println(mm+"给你献花");
    }
    public void giveDolls(){
        System.out.println(mm+"给你洋娃娃");
    }
    public void giveChocolate(){
        System.out.println(mm+"给你巧克力");
    }
}

package DesignPatten.FactoryMethod;

public class fm {
    public static void main(String[] args){
        IFactory factory = new UndergraduateFactory();
        LeiFeng student = factory.createLeiFeng();
        student.BuyRice();
        student.Sweep();
        student.Wash();
    }
}

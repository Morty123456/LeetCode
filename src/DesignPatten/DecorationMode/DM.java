package DesignPatten.DecorationMode;

public class DM {
    public static void main(String[] args){
        Person xc = new Person("小菜");
        TShirts ts = new TShirts();
        BigTourse bt = new BigTourse();

        ts.Decorate(xc);
        bt.Decorate(ts);

        bt.show();
    }
}

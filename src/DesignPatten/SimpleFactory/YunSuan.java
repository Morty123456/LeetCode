package DesignPatten.SimpleFactory;

public class YunSuan {
    public static void main(String[] args){
        Operation operation = new OperationFactory().createFactory("-");
        operation.setNumberA(1);
        operation.setNumberB(2);
        System.out.println(operation.GetResult());
    }
}

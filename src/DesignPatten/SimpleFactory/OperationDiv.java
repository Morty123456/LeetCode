package DesignPatten.SimpleFactory;

public class OperationDiv extends Operation{
    @Override
    public double GetResult(){
        double result = 0;
        if (getNumberB()==0)
            System.out.println("除数不能为0");
        else
            result = getNumberA()/getNumberB();
        return result;
    }
}

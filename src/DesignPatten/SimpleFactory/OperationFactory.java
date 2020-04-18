package DesignPatten.SimpleFactory;

public class OperationFactory {
    public Operation createFactory(String operate){
        Operation operation = null;
        switch (operate){
            case "+":{
                operation = new OperationAdd();
                break;
            }
            case "-":{
                operation = new OperationSub();
                break;
            }
            case "*":{
                operation = new OperationMul();
                break;
            }
            case "/":{
                operation = new OperationDiv();
                break;
            }
        }
        return operation;
    }
}

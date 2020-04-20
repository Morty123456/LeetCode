package DesignPatten.ResponsibilityChain;

public class Majordomo extends Manager{
    public Majordomo(String name){
        super(name);
    }
    @Override
    public void RequestApplications(Request request){
        if (request.RequestType=="请假" && request.Number<=5)
            System.out.println(name+"："+request.RequestType+"：数量"+request.Number+"被批准");
        else {
            if (superior!=null)
                superior.RequestApplications(request);
        }
    }
}

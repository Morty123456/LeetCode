package DesignPatten.ResponsibilityChain;

public class rm {
    public static void main(String[] args){
        CommomManager jinli = new CommomManager("金利");
        Majordomo zongjian = new Majordomo("总监");
        GeneralManager zhongjingli = new GeneralManager("钟经理");
        jinli.SetSuperior(zongjian);
        zongjian.SetSuperior(zhongjingli);

        Request request = new Request();
        request.Number=2;
        request.RequestType="请假";
        jinli.RequestApplications(request);

        request.Number=5;
        request.RequestType="请假";
        jinli.RequestApplications(request);

        request.Number=2000;
        request.RequestType="加薪";
        jinli.RequestApplications(request);
    }
}

package DesignPatten.ComponentMethod;

public class cm {
    public static void main(String[] args){
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.Add(new HRDepartment("总部人力资源部门"));
        root.Add(new FinanceDepartment("总部财务部门"));

        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.Add(new HRDepartment("华东分公司人力资源部门"));
        comp.Add(new FinanceDepartment("华东分公司财务部门"));
        root.Add(comp);

        ConcreteCompany comp1 = new ConcreteCompany("南京办事处");
        comp1.Add(new HRDepartment("南京办事处人力资源部门"));
        comp1.Add(new FinanceDepartment("南京办事处财务部门"));
        comp.Add(comp1);

        ConcreteCompany comp2 = new ConcreteCompany("杭州办事处");
        comp2.Add(new HRDepartment("杭州办事处人力资源部门"));
        comp2.Add(new FinanceDepartment("杭州办事处财务部门"));
        comp.Add(comp2);

        root.Display(1);
        root.LineOfDuty();
    }
}

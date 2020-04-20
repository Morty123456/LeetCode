package DesignPatten.ComponentMethod;

public class FinanceDepartment extends Company {
    public FinanceDepartment(String name){
        super(name);
//        this.name = name;
    }
    @Override
    public void Add(Company c){}
    @Override
    public void Remove(Company c){}
    @Override
    public void Display(int depth){
        for (int i=0;i<=depth;i++)
            System.out.print("-");
        System.out.println(name);
    }
    @Override
    public void LineOfDuty(){
        System.out.println(name + "公司财务收支管理");
    }
}

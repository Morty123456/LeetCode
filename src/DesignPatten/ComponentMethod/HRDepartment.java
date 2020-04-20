package DesignPatten.ComponentMethod;

public class HRDepartment extends Company {
    public HRDepartment(String name){
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
        System.out.println(name + "员工招聘培训");
    }
}

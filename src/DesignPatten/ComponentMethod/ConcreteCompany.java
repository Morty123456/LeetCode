package DesignPatten.ComponentMethod;

import java.util.LinkedList;


public class ConcreteCompany extends Company {
    private LinkedList<Company> list = new LinkedList<>();
    public ConcreteCompany(String name){
        super(name);
//        this.name = name;
    }
    @Override
    public void Add(Company c){
        list.add(c);
    }
    @Override
    public void Remove(Company c){
        list.remove(c);
    }
    @Override
    public void Display(int depth){
        for (int i=0;i<=depth;i++)
            System.out.print("-");
        System.out.println(name);
        for (Company c : list){
            c.Display(depth+2);
        }
    }
    @Override
    public void LineOfDuty(){
        for (Company c : list){
            c.LineOfDuty();
        }
    }
}

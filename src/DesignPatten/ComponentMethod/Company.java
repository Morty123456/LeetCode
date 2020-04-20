package DesignPatten.ComponentMethod;

abstract class Company {
    protected String name;
    public Company(String name){
        this.name = name;
    }
//    public Company(){};
//    public Company(){}
    public abstract void Add(Company c);
    public abstract void Remove(Company c);
    public abstract void Display(int depth);
    public abstract void LineOfDuty();
}

package DesignPatten.ResponsibilityChain;

abstract class Manager {
    protected String name;
    protected Manager superior;
    public Manager(String name){
        this.name=name;
    }
    public void SetSuperior(Manager superior){
        this.superior = superior;
    }
     abstract public void RequestApplications(Request request);
}

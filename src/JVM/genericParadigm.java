package JVM;

import java.util.ArrayList;
import java.util.List;

public class genericParadigm {
    public static void main(String[] args){
//        List list = new ArrayList();
//        list.add("qqyumidi");
//        list.add("corn");
//        list.add(100);
//        for (int i=0;i<list.size();i++)
//            System.out.println((String)list.get(i));
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(10);
        System.out.println(name.getClass());
        System.out.println(age.getClass());
        System.out.println(name.getClass() == age.getClass());
    }
}
class Box<T>{
    public T data;
    public Box(){};
    public Box(T data){
        this.data=data;
    }
    public T getData(){
        return data;
    }
}

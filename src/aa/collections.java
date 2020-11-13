package aa;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/7/16 16:21
 * @description:
 */
public class collections {
    public static void main(String[] args){
        Person person1 = new Person(12,"wzh");
        Person person2 = new Person(13, "xl");
        Person person3 = new Person(14, "xp");
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(person1);
        linkedList.add(person2);
        linkedList.add(person3);
        Collections.sort(linkedList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age < o2.age)
                    return 1;
                else
                    return -1;
            }
        });
        for (Person person: linkedList)
            System.out.println(person.age+" "+person.name);
    }
}
class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

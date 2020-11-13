package aa;

import java.lang.reflect.Field;

public class test10 {
    public static void main(String[] args) {
        final Person p = new Person();
        try {
            reflect(p);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void reflect(Person p) throws NoSuchFieldException, IllegalAccessException {
        Class clz = p.getClass();
        Field name = clz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "law");
        System.out.println(name.get(p));
        System.out.println(p.getName());
    }
    static class Person{
        //如果一开始final变量就被指定，则不可以使用反射修改；如果是在构造函数中赋值，则可以通过反射修改
        private final String name;
        public Person(){
            this.name="wzh";
        }
        public String getName() {
            return name;
        }
    }
}


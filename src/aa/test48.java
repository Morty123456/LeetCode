package aa;

import java.util.Scanner;

public class test48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String typed = sc.nextLine();
        System.out.println(isName(name, typed));
    }
    public static boolean isName(String name, String typed){
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int nameLeft = 0, typeLeft = 0;
        while (nameLeft < names.length && typeLeft < typeds.length){
            if (names[nameLeft]==typeds[typeLeft]){
                nameLeft++;
                typeLeft++;
            }else if (typeLeft>0 && typeds[typeLeft]==typeds[typeLeft-1]){
                typeLeft++;
            }else
                return false;
        }
        while (typeLeft < typeds.length){
            if (typeds[typeLeft]==typeds[typeLeft-1])
                typeLeft++;
            else
                return false;
        }
        return nameLeft==names.length && typeLeft==typeds.length;
    }
}

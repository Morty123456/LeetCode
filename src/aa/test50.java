package aa;

import java.util.Scanner;

public class test50 {
    static double count = 0;
    static int n;
    static int m;
    static double proA;
    static double proB;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        proA = sc.nextDouble();
        proB = sc.nextDouble();
        dfs(1,1,1);
        System.out.println(count);
    }

    public static void dfs(int nowPeople, int nowDay, double proNow){
        if (nowPeople==1){
            count = count + proNow;
        }
        if (nowDay==m)
            return;
        if (nowPeople==n){
            dfs(nowPeople, nowDay+1, proNow*proA*proB);
            dfs(nowPeople-1, nowDay+1, proNow*(1-proA)*proB);
        }else if (nowPeople==1){
            dfs(nowPeople, nowDay+1, proNow*proA*proB+proNow*(1-proA)*(1-proB));
            dfs(nowPeople+1, nowDay+1, proNow*proA*(1-proB));
        } else {
            dfs(nowPeople, nowDay+1, proNow*proA*proB+proNow*(1-proA)*(1-proB));
            dfs(nowPeople-1, nowDay+1, proNow*(1-proA)*proB);
            dfs(nowPeople+1, nowDay+1, proNow*proA*(1-proB));
        }

    }
}

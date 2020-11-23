package aa;

public class test75 {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canComplete(gas, cost));
    }
    public static int canComplete(int[] gas, int[] cost){
        for (int i=0; i<gas.length; i++){
            if (gas[i]<cost[i])
                continue;
            int slave = gas[i]-cost[i];
            int now = i==gas.length-1?0:i+1;
            while (now!=i && slave>=0){
                slave += gas[now]-cost[now];
                if(now==gas.length-1)
                    now = 0;
                else
                    now++;
            }
            if (now==i && slave>=0)
                return i;
        }
        return -1;
    }
}

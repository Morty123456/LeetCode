package NowCoder;

import DesignPatten.ResponsibilityChain.Majordomo;

import java.util.*;

public class wangyi_niuniuFindJob {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ai = new int[m+n];
        for (int i=0;i<n;i++){
            int di = sc.nextInt();
            ai[i] = di;
            int pi = sc.nextInt();
            map.put(di, pi);
        }
        int[] bi = new int[m];
        for (int i=0;i<m;i++){
            ai[i+n] = sc.nextInt();
            bi[i] = ai[i+n];
            if (!map.containsKey(ai[i+n]))
                map.put(ai[i+n], 0);
        }
        Arrays.sort(ai);
        int ma = 0;
        for (int i=0;i<m+n;i++){
            ma = Math.max(ma, map.get(ai[i]));
            map.put(ai[i], ma);
        }
        for (int i=0;i<m;i++)
            System.out.println(map.get(bi[i]));
    }
}

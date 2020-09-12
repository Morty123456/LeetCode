package NowCoder.wangyi;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/9/12 14:17
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String man = sc.nextLine();
        String woman = sc.nextLine();
        int sum = sc.nextInt();
        int[][] heart = new int[sum][2];
        for (int i=0; i<sum; i++){
            heart[i][0] = sc.nextInt();
            heart[i][1] = sc.nextInt();
        }
        System.out.println(solution(heart));
    }
    public static int solution(int[][] heart) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> pickWoman = new HashMap<>();
        HashMap<Integer, Integer> pickMan = new HashMap<>();
        for (int[] h : heart) {
            hashMap.put(h[1], h[0]);
            if (pickWoman.containsKey(h[1])) {
                pickWoman.put(h[1], pickWoman.get(h[1]) + 1);
            } else {
                pickWoman.put(h[1], 1);
            }
            if (pickMan.containsKey(h[1])) {
                pickMan.put(h[1], pickMan.get(h[1]) + 1);
            } else {
                pickMan.put(h[1], 1);
            }
        }
        //女生升序
        List<Map.Entry<Integer, Integer>> womanList = new ArrayList<Map.Entry<Integer, Integer>>(pickWoman.entrySet());
        Collections.sort(womanList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        //男生降序
        List<Map.Entry<Integer, Integer>> manList = new ArrayList<>(pickMan.entrySet());
        Collections.sort(manList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int sum = 0;
        HashSet<Integer> pickedMan = new HashSet<>();
        //找到被最少人选的那个女生
        for (Map.Entry entry : womanList) {
            int woman = (int)entry.getKey();
            int max = 0;
            int man = 0;
//            for (Map.Entry manEntry : manList){
//                if (!pickedMan.contains(manEntry.getKey()) && (int)manEntry.getValue()==woman){
//
//                }
//            }
            //找到选这个女生的男生中，选择女生最多的那个
            for (Map.Entry entry1 : hashMap.entrySet()){
                if ((int)entry1.getValue()==woman){
                    int thisMan = (int)entry1.getKey();
                    if (!pickedMan.contains(thisMan)){
                        int val = pickMan.get(thisMan);
                        if (val>max){
                            max = val;
                            man = thisMan;
                        }
                    }
                }
            }
            pickedMan.add(man);
            sum++;
        }
        return sum;
    }
}

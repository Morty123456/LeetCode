package LeetCode;

import java.util.*;

/**
 * @author: wzh
 * @time: 2020/8/4 10:11
 * @description:
 */
public class Medium_canFinish {
    public static void main(String[] args){

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        int[] inCount = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        for (int[] num : prerequisites){
            inCount[num[0]]++;
            lists.get(num[1]).add(num[0]);
        }
        for (int i=0;i<numCourses;i++){
            if (inCount[i]==0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for (int cur : lists.get(pre)){
                if (--inCount[cur] == 0)
                    queue.add(cur);
            }
        }
        return numCourses==0;
    }
}

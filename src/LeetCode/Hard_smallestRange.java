package LeetCode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: wzh
 * @time: 2020/8/1 19:09
 * @description:
 */
public class Hard_smallestRange {
    public static void main(String[] args){
    }
    public static int[] smallestRange(List<List<Integer>> nums){
        int n = nums.size();
        int max = Integer.MIN_VALUE;
        int begin = 0, end = Integer.MAX_VALUE;
        PriorityQueue<smallestRangeNode> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.val, o2.val)));
        //合并链表
        for (int i=0;i<n;i++){
            int val = nums.get(i).get(0);
            pq.offer(new smallestRangeNode(i, 0, val));
            max = Math.max(max, val);
        }
        //必须包含k个元素
        while (pq.size()==n){
            smallestRangeNode node = pq.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;
            //更新区间长度
            if (max-val < end-begin){
                begin = val;
                end = max;
            }
            //为堆中填充元素
            //每次都是弹出最小的，然后再加进去一个节点（弹出节点所在的链表）
            if (j+1 < nums.get(i).size()){
                int nVal = nums.get(i).get(j+1);
                pq.offer(new smallestRangeNode(i, j+1, nVal));
                max = Math.max(max, nVal);
            }
        }
        return new int[]{begin, end};
    }
}
class smallestRangeNode{
    int i, j, val;
    public smallestRangeNode(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

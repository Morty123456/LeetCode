package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Medium_TopKFrequentElements {
    public static void main(String[] args){
        int[] nums = {2,2,2,3,1,1};
        int k = 2;
        System.out.println(topKFrequentBucketSort(nums, k).toString());
    }
    public static List<Integer> topKFrequent(int[] nums, int k){
        List<Integer> fre = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
//        for (int num : nums){
//            if (map.containsKey(num))
//                map.put(num, map.get(num)+1);
//            else
//                map.put(num, 1);
//        }
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int num : map.keySet()){
            int f = map.get(num);
            if (!treeMap.containsKey(f))
                treeMap.put(f, new LinkedList<>());
            treeMap.get(f).add(num);
        }
        while (fre.size()<k){
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            fre.addAll(entry.getValue());
        }
        return fre;
    }
    public static List<Integer> topKFrequentBucketSort(int[] nums, int k){
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        //HashMap，key-value键值对，一次遍历出每一个值的个数
        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0)+1);
        for (int key : frequencyMap.keySet()){
            //fre是每个数字出现的次数
            int fre = frequencyMap.get(key);
            //把这个次数的 数字 都放到链表中
            if (bucket[fre] == null)
                bucket[fre] = new ArrayList<>();
            bucket[fre].add(key);
        }
        List<Integer> res = new ArrayList<>();
        //从高到底遍历链表
        //空的跳过，把非空的加到res中
        //当res数量够了，就结束
        for (int pos = bucket.length-1; pos>=0 && res.size()<k; pos--){
            if (bucket[pos]!=null)
                res.addAll(bucket[pos]);
        }
        return res;
    }
}

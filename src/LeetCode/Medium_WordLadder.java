package LeetCode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 单词变换最短路径
 * @author: wzh
 * @create: 2020-01-14 09:20
 **/
public class Medium_WordLadder {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(LeetCodeladderLeladderLength(beginWord, endWord, wordList));
//        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    //LeetCode参考答案
    public static int LeetCodeladderLeladderLength(String start, String end, List<String> dict){
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()){
            String str = queue.poll();
            if (str != null){
                for (int i=0;i<str.length();i++){
                    char[] chars = str.toCharArray();
                    for (char c='a'; c<='z'; c++){
                        chars[i] =c;
                        String word= new String(chars);
                        if (word.equals(end))
                            return level+1;
                        if (dict.contains(word) && !visited.contains(word)){
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            }
            else{
                level++;
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return 0;
    }
    //BFS广度搜索
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Map<String, List<String>> graph = constructGraph(wordList, beginWord, endWord);
        LinkedList<WordAndStep> stack = new LinkedList<>();
        HashSet<String> visitedList = new HashSet<>();
        //广度优先搜索
        stack.add(new WordAndStep(beginWord, 1));
        visitedList.add(beginWord);
        while (!stack.isEmpty()){
            WordAndStep wordAndstep = stack.poll();
            if (wordAndstep.getWord().equals(endWord))
                return wordAndstep.getStep();
            else {
                int step = wordAndstep.getStep();
                List<String> wordListWord = graph.get(wordAndstep.getWord());
                for (String word : wordListWord){
                    if (!visitedList.contains(word)){
                        stack.add(new WordAndStep(word, step+1));
                        System.out.println(word+" "+step);
                        visitedList.add(word);
                    }
                }
            }
        }
        return 0;
    }
    //获得所有单词的邻接表
    public static Map<String, List<String>> constructGraph(List<String> wordList, String beginWord, String endWord){
        wordList.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0;i<wordList.size();i++)
            map.put(wordList.get(i), new ArrayList<>());
        for (int i=0;i<wordList.size();i++){
            for (int j=i;j<wordList.size();j++){
                if (canTransform(wordList.get(i), wordList.get(j))){
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        return map;
    }
    //判断两个单词是否只有一个字符不同
    public static boolean canTransform(String source, String target){
        int difNum = 0;
        for (int i=0;i<source.length();i++){
            if (source.charAt(i) != target.charAt(i))
                difNum++;
        }
        return difNum==1;
    }
}
class WordAndStep{
    String word;
    int step;
    WordAndStep(String word, int step){
        this.word = word;
        this.step = step;
    }
    public int getStep() {
        return step;
    }
    public String getWord(){
        return word;
    }
}
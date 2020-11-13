package aa;

import java.util.*;

public class test59 {
    public static void main(String[] args) {

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size()==0 || wordSet.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            for (int i=0; i<currentSize; i++){
                String currentWod = queue.poll();
                if (changeWordEveryOneLetter(currentWod, endWord, queue, visited, wordSet)){
                    return step+1;
                }
            }
            step++;
        }
        return 0;
    }
    public static boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet){
        char[] charArray = currentWord.toCharArray();
        for (int i=0; i<endWord.length(); i++){
            char originChar = charArray[i];
            for (char k='a'; k<='z'; k++){
                if (k==originChar){
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)){
                    if (nextWord.equals(endWord)){
                        return true;
                    }
                    if (!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}

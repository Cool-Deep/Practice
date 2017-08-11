package com.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 150s qs 18.10
 * Given two words of equal length in dictionary convert one word to another one letter at a time
 * in such a way that all intermediate words are int the dictionary
 */
class ConvertOneWordToAnother {

    private void convert(String word1, String word2, Set<String> dict) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();
        queue.add(word1);
        visited.add(word1);
        while (queue.size() != 0) {
            String word = queue.poll();
            if (word.equals(word2)) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    String newWord = replace(word, i, (char) ch);
                    if (dict.contains(newWord)){
                        if (!visited.contains(newWord)) {
                            parentMap.put(newWord, word);
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        String word = word2;
        while(word != null){
            System.out.println(word);
            word = parentMap.get(word);
        }

    }

    private String replace(String newWord, int pos, char ch) {
        String buffer = newWord.substring(0, pos) +
                ch +
                newWord.substring(pos + 1, newWord.length());
        return buffer;
    }

    
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("cat");
        dictionary.add("pat");
        dictionary.add("pit");
        dictionary.add("pid");
        dictionary.add("did");
        ConvertOneWordToAnother cow = new ConvertOneWordToAnother();
        cow.convert("cat", "did", dictionary);
    }
}

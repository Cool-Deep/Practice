package com.interview.suffixprefix;

import java.util.HashMap;
import java.util.Map;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
///**
// * Date 04/25/2016
// * @author Tushar Roy
// *
// * Insert/delete/search into trie data structure
// *
// * Reference
// * https://en.wikipedia.org/wiki/Trie
// */
//class Trie {
//
//    private class TrieNode {
//        final Map<Character, TrieNode> children;
//        boolean endOfWord;
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////        public TrieNode() {
////            children = new HashMap<>();
////            endOfWord = false;
////        }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//    }
//
//    private final TrieNode root;
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public Trie() {
////        root = new TrieNode();
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    /**
////     * Iterative implementation of insert into trie
////     */
////    public void insert(String word) {
////        TrieNode current = root;
////        for (int i = 0; i < word.length(); i++) {
////            char ch = word.charAt(i);
////            TrieNode node = current.children.get(ch);
////            if (node == null) {
////                node = new TrieNode();
////                current.children.put(ch, node);
////            }
////            current = node;
////        }
////        //mark the current nodes endOfWord as true
////        current.endOfWord = true;
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    /**
////     * Recursive implementation of insert into trie
////     */
////    public void insertRecursive(String word) {
////        insertRecursive(root, word, 0);
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//
//    private void insertRecursive(TrieNode current, String word, int index) {
//        if (index == word.length()) {
//            //if end of word is reached then mark endOfWord as true on current node
//            current.endOfWord = true;
//            return;
//        }
//        char ch = word.charAt(index);
//        TrieNode node = current.children.get(ch);
//
//        //if node does not exists in map then create one and put it into map
//        if (node == null) {
//            node = new TrieNode();
//            current.children.put(ch, node);
//        }
//        insertRecursive(node, word, index + 1);
//    }
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    /**
////     * Iterative implementation of search into trie.
////     */
////    public boolean search(String word) {
////        TrieNode current = root;
////        for (int i = 0; i < word.length(); i++) {
////            char ch = word.charAt(i);
////            TrieNode node = current.children.get(ch);
////            //if node does not exist for given char then return false
////            if (node == null) {
////                return false;
////            }
////            current = node;
////        }
////        //return true of current's endOfWord is true else return false.
////        return current.endOfWord;
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    /**
////     * Recursive implementation of search into trie.
////     */
////    public boolean searchRecursive(String word) {
////        return searchRecursive(root, word, 0);
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//    private boolean searchRecursive(TrieNode current, String word, int index) {
//        if (index == word.length()) {
//            //return true of current's endOfWord is true else return false.
//            return current.endOfWord;
//        }
//        char ch = word.charAt(index);
//        TrieNode node = current.children.get(ch);
//        //if node does not exist for given char then return false
//        if (node == null) {
//            return false;
//        }
//        return searchRecursive(node, word, index + 1);
//    }
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    /**
////     * Delete word from trie.
////     */
////    public void delete(String word) {
////        delete(root, word, 0);
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//    /**
//     * Returns true if parent should delete the mapping
//     */
//    private boolean delete(TrieNode current, String word, int index) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
}

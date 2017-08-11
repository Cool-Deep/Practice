package com.interview.misc;

import java.util.List;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Created by tushar_v_roy on 3/10/16.
//// */
////class PalindromePair {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public List<List<Integer>> palindromePairs(String[] words) {
//////        Trie trie = new Trie();
//////        for (String word: words) {
//////            trie.insert(reverse(word));
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////        }
////
////        return null;
////    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private String reverse(String word) {
        return word;
    }
}

class TrieNode {
    final TrieNode[] child = new TrieNode[26];
    boolean isWord;
    public TrieNode() {

    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = (char)(word.charAt(i) - 'a');

            if (current.child[ch] == null) {
                current.child[ch] = new TrieNode();
            }
            current = current.child[ch];
        }
        current.isWord = true;
    }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//        TrieNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = (char)(word.charAt(i) - 'a');
//            if (current.child[ch] == null) {
//                return false;
//            }
//            current = current.child[ch];
//        }
//        return current.isWord;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    private boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = (char)(prefix.charAt(i) - 'a');
            if (current.child[ch] == null) {
                return false;
            }
            current = current.child[ch];
        }
        return true;
    }

    public static void main(String args[]) {
        Trie t = new Trie();
        t.insert("hello");
        System.out.println(t.startsWith("hell"));
    }
}

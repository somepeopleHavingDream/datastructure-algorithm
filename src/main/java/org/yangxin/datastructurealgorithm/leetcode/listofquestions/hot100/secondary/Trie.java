package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/14 21:04
 */
@SuppressWarnings("DuplicatedCode")
public class Trie {

    private final TrieNode root;

    private static class TrieNode {
        private boolean isEnd;
        private final TrieNode[] next;

        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
            this.next = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode(false);
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.next[index] == null) {
                current.next[index] = new TrieNode(false);
            }

            current = current.next[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.next[index] == null) {
                return false;
            }

            current = current.next[index];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.next[index] == null) {
                return false;
            }

            current = current.next[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

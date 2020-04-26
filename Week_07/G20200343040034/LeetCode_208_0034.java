package com.alang.learn.week7;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_208_0034 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        assert trie.search("apple");   // 返回 true
        assert !trie.search("app");     // 返回 false
        assert trie.startsWith("app"); // 返回 true
        trie.insert("app");
        assert trie.search("app");     // 返回 true
        trie.insert("answer");
        assert !trie.startsWith("app"); //返回false
    }

    static class Trie {
        private static final int SIZE = 26;
        /**
         * Initialize your data structure here.
         */
        private final Trie[] children;
        boolean end;

        public Trie() {
            children = new Trie[SIZE];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie root = this;
            for (int i = 0, l = word.length(); i < l; i++) {
                int index = word.charAt(i) - 'a';
                if (root.children[index] == null) root.children[index] = new Trie();
                root = root.children[index];
            }
            root.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie root = this;
            for (int i = 0, l = word.length(); i < l; i++) {
                int index = word.charAt(i) - 'a';
                if (root.children[index] == null) return false;
                root = root.children[index];
            }
            return root.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie root = this;
            for (int i = 0, l = prefix.length(); i < l; i++) {
                int index = prefix.charAt(i) - 'a';
                if (root.children[index] == null) return false;
                root = root.children[index];
            }
            return true;
        }
    }
}

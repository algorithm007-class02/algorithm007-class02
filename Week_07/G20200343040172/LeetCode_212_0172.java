package week07.g20200343040172;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode_212_单词搜索
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class LeetCode_212_0172 {
    /**
     * 使用前缀树 + DFS
     */
    class Solution1 {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> ans = new ArrayList<>();
            Set<String> set = new HashSet<>();
            if (words == null || board == null) {
                return ans;
            }
            // 矩阵的行
            int m = board.length;

            // 矩阵的列
            int n = board[0].length;

            Trie trie = new Trie();

            // 向trie中插入单词
            for (String word : words) {
                trie.insert(word);
            }

            boolean[][] visited = new boolean[m][n];
            //String start = board[0][0] + "";
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    dfs(board, trie, i, j, board[i][j] + "", set, m, n, visited);
                }
            }
            for (String word : set) {
                ans.add(word);
            }
            return ans;
        }

        public void dfs(char[][] board, Trie trie, int i, int j, String start, Set<String> set, int m, int n, boolean[][] visited) {
            if (i < 0 || i >= m) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            if (j < 0 || j >= n) {
                return;
            }
            if (!trie.startsWith(start)) {
                return;
            }
            if (trie.search(start)) {
                if (!set.contains(start)) {
                    set.add(start);
                }
            }
            visited[i][j] = true;
            // 往下
            if (i + 1 < m) {
                dfs(board, trie, i + 1, j, start + board[i + 1][j], set, m, n, visited);
            }
            // 往上
            if (i - 1 >= 0) {
                dfs(board, trie, i - 1, j, start + board[i - 1][j], set, m, n, visited);
            }
            // 往右
            if (j + 1 < n) {
                dfs(board, trie, i, j + 1, start + board[i][j + 1], set, m, n, visited);
            }
            // 往左
            if (j - 1 >= 0) {
                dfs(board, trie, i, j - 1, start + board[i][j - 1], set, m, n, visited);
            }
            visited[i][j] = false;
        }

        class Trie {
            class TrieNode {
                // R links to node children
                private TrieNode[] links;

                private final int R = 26;

                private boolean isEnd;

                public TrieNode() {
                    links = new TrieNode[R];
                }

                public boolean containsKey(char ch) {
                    return links[ch - 'a'] != null;
                }

                public TrieNode get(char ch) {
                    return links[ch - 'a'];
                }

                public void put(char ch, TrieNode node) {
                    links[ch - 'a'] = node;
                }

                public void setEnd() {
                    isEnd = true;
                }

                public boolean isEnd() {
                    return isEnd;
                }
            }

            private TrieNode root;


            public Trie() {
                root = new TrieNode();
            }

            // Inserts a word into the trie.
            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char currentChar = word.charAt(i);
                    if (!node.containsKey(currentChar)) {
                        node.put(currentChar, new TrieNode());
                    }
                    node = node.get(currentChar);
                }
                node.setEnd();
            }

            // search a prefix or whole key in trie and
            // returns the node where search ends
            private TrieNode searchPrefix(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char curLetter = word.charAt(i);
                    if (node.containsKey(curLetter)) {
                        node = node.get(curLetter);
                    } else {
                        return null;
                    }
                }
                return node;
            }

            // Returns if the word is in the trie.
            public boolean search(String word) {
                TrieNode node = searchPrefix(word);
                return node != null && node.isEnd();
            }


            // Returns if there is any word in the trie
            // that starts with the given p
            public boolean startsWith(String prefix) {
                TrieNode node = searchPrefix(prefix);
                return node != null;
            }
        }
    }
}

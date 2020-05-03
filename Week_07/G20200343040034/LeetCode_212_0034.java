package com.alang.learn.week7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_212_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(grid, words));
    }

    static class Solution {
        private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        private class Trie {
            Trie[] next = new Trie[26];
            String val;

            public void insert(String word) {
                Trie root = this;
                for (int i = 0, l = word.length(); i < l; i++) {
                    int index = word.charAt(i) - 'a';
                    if (root.next[index] == null) root.next[index] = new Trie();
                    root = root.next[index];
                }
                root.val = word;
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            ArrayList<String> result = new ArrayList<>();
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return result;
            int m = board.length, n = board[0].length;
            Trie trie = new Trie();
            for (String s : words) {
                trie.insert(s);
            }
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    find(board, i, j, m, n, set, trie);
            return new ArrayList<>(set);
        }

        private void find(char[][] board, int i, int j, int m, int n, HashSet<String> result, Trie parent) {
            if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == '#') {
                return;
            }
            Trie current = parent.next[board[i][j] - 'a'];
            if (current != null) {
                if (current.val != null) {
                    result.add(current.val);
                }
                char temp = board[i][j];
                board[i][j] = '#';
                for (int[] arr : dir) {
                    find(board, i + arr[0], j + arr[1], m, n, result, current);
                }
                board[i][j] = temp;
            }
        }
    }
}

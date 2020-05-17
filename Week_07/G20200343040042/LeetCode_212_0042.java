package com.yequan.leetcode.trie.findWords_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * //给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * //
 * // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * //
 * //
 * // 示例:
 * //
 * // 输入:
 * //words = ["oath","pea","eat","rain"] and board =
 * //[
 * //  ['o','a','a','n'],
 * //  ['e','t','a','e'],
 * //  ['i','h','k','r'],
 * //  ['i','f','l','v']
 * //]
 * //
 * //输出: ["eat","oath"]
 * //
 * // 说明:
 * //你可以假设所有输入都由小写字母 a-z 组成。
 * //
 * // 提示:
 * //
 * //
 * // 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * // 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
 * //实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * //
 * // Related Topics 字典树 回溯算法
 *
 * @author : Administrator
 * @date : 2020/5/1
 */
public class FindWords_II {

    private int row;
    private int column;
    private char[][] board;
    private boolean[][] marked;
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        if (null == board || (row = board.length) == 0) {
            return new ArrayList<>(ans);
        }
        column = board[0].length;
        marked = new boolean[row][column];
        this.board = board;
        WordTrie wordTrie = new WordTrie();
        for (String word : words) {
            wordTrie.insertWord(word);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                search(i, j, wordTrie.root, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    private void search(int i, int j, TrieNode node, Set<String> ans) {
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j]) {
            return;
        }
        node = node.links[board[i][j] - 'a'];
        marked[i][j] = true;
        if (null == node) {
            marked[i][j] = false;
            return;
        }
        //找到单词
        if (node.isEnd) {
            ans.add(node.value);
        }
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            search(newX, newY, node, ans);
        }
        marked[i][j] = false;
    }

    class WordTrie {
        TrieNode root;

        public WordTrie() {
            this.root = new TrieNode();
        }

        public void insertWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.links[currentChar - 'a'] == null) {
                    node.links[currentChar - 'a'] = new TrieNode();
                }
                node = node.links[currentChar - 'a'];
            }
            node.isEnd = true;
            node.value = word;
        }
    }

    class TrieNode {
        String value;
        TrieNode[] links;
        boolean isEnd = false;

        public TrieNode() {
            this.links = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String[] words = {"a"};
        FindWords_II findWords_ii = new FindWords_II();
        List<String> ans = findWords_ii.findWords(board, words);
        System.out.println(ans.toString());
    }

}

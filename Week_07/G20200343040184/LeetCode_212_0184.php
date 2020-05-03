//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=212 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 212. 单词搜索 II [困难]
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 提示:
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TrieNode {
    public $children = [];
    public $word;
}
class Trie {
    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this->root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        $node = &$this->root;
        $n = strlen($word);
        $nword = str_split($word);
        foreach ($nword as $char) {
            if (!$node->children[$char]) $node->children[$char] = new TrieNode();
            $node = &$node->children[$char];
        }
        $node->word = $word;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $node = $this->root;
        $nword = str_split($word);
        foreach ($nword as $char) {
            if (!$node->children[$char]) return false;
            $node = $node->children[$char];
        }
        return $node->word == $word;
    }
    public function getRoot()
    {
        return $this->root;
    }
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $node = $this->root;
        $word = str_split($prefix);
        foreach ($word as $char) {
            if (!$node->children[$char]) return false;
            $node = $node->children[$char];
        }
        return true;
    }
}
class Solution {
    private $res = [];
    /**
     * 标准trie数
     * @param String[][] $board
     * @param String[] $words
     * @return String[]
     */
    function findWords1($board, $words) {
        $trie = new Trie();
        foreach ($words as $word) {
            $trie->insert($word);
        }
        $n = count($board);
        $m = count($board[0]);
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++){
                if ($trie->startsWith($board[$i][$j])) {
                    $this->backtracking1($board, $i, $j,$n, $m, $trie->getRoot());
                }
            }
        }
        return $this->res;
    }

    function backtracking1(&$board, $i, $j,$n, $m, &$root) 
    {
        $letter = $board[$i][$j];
        if ($letter == '#')  return;
        $board[$i][$j] = '#';
        $currNode = &$root->children[$letter];
        if ($currNode->word) {
            $this->res[] = $currNode->word;
            $currNode->word = null;
        }
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        for ($k = 0; $k < 4; $k++) {
            $ni = $i + $dx[$k];
            $nj = $j + $dy[$k];
            if ($ni < 0 || $ni >= $n || $nj < 0 || $nj >= $m || $board[$ni][$nj] == '#') continue;
            if ($currNode->children[$board[$ni][$nj]]) {
                $this->backtracking($board, $ni, $nj, $n, $m, $currNode);
            }
        }
        $board[$i][$j] = $letter;
    }

    function findWords($board, $words) {
        $trie = [];
        foreach ($words as $word) {
            $node = &$trie;
            $chars = str_split($word);
            foreach ($chars as $char) {
                if (empty($node[$char])) $node[$char] = [];
                $node = &$node[$char];
            }
            $node['$'] = $word;
        }
        $n = count($board);
        $m = count($board[0]);
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++){
                if (!empty($trie[$board[$i][$j]])) {
                    $this->backtracking($board, $i, $j, $n, $m, $trie);
                }
            }
        }
        return $this->res;
    }
    function backtracking(&$board, $i, $j, $n, $m, &$trie) {
        $letter = $board[$i][$j];
        if ($letter == '#') return;
        $board[$i][$j] = '#';
        $node = &$trie[$letter];
        if ($node['$']) {
            $this->res[] = $node['$'];
            $node['$'] = null;
        }
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        for ($k = 0; $k < 4; $k++) {
            $ni = $i + $dx[$k];
            $nj = $j + $dy[$k];
            if ($ni < 0 || $ni >= $n || $nj < 0 || $nj >= $m || $board[$ni][$nj] == '#') continue;
            if (!empty($node[$board[$ni][$nj]])) {
                $this->backtracking($board, $ni, $nj, $n, $m, $node);
            }
        }
        $board[$i][$j] = $letter;
    }
}
// @lc code=end

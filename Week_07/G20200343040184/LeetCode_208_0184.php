//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=208 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 208. 实现 Trie (前缀树) [中等]
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * Trie trie = new Trie();
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
//数组实现方式
class TrieArray {
    /**
     * 数组方式实现
     * Initialize your data structure here.
     */
    function __construct() {
        $this->root = [];
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        $node = &$this->root;
        $len = strlen($word);
        for ($i = 0; $i < $len; $i++) {
            if (!$node[$word[$i]]) {
                $node[$word[$i]] = [0];
            }
            $node = &$node[$word[$i]];
        }
        $node[0] = 1;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $node = $this->root;
        $len = strlen($word);
        for ($i = 0; $i < $len; $i++) {
            if (!$node[$word[$i]]) return false;
            $node = $node[$word[$i]];
        }
        return $node[0] == 1;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $node = $this->root;
        $len = strlen($prefix);
        for ($i = 0; $i < $len; $i++) {
            if (!$node[$prefix[$i]]) return false;
            $node = $node[$prefix[$i]];
        }
        return true;
    }
}
class TrieNode {
    public $end = false;
    public $children = [];
}
class Trie {
    /**
     * 数组方式实现
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
        $len = strlen($word);
        for ($i = 0; $i < $len; $i++) {
            if (!$node->children[$word[$i]]) {
                $node->children[$word[$i]] = new TrieNode();
            }
            $node = &$node->children[$word[$i]];
        }
        $node->end = true;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $node = $this->root;
        $len = strlen($word);
        for ($i = 0; $i < $len; $i++) {
            if (!$node->children[$word[$i]]) return false;
            $node = $node->children[$word[$i]];
        }
        return $node->end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $node = $this->root;
        $len = strlen($prefix);
        for ($i = 0; $i < $len; $i++) {
            if (!$node->children[$prefix[$i]]) return false;
            $node = $node->children[$prefix[$i]];
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * $obj = Trie();
 * $obj->insert($word);
 * $ret_2 = $obj->search($word);
 * $ret_3 = $obj->startsWith($prefix);
 */
// @lc code=end

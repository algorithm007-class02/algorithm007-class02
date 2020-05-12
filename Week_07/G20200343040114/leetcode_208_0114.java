/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (65.42%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    35.7K
 * Total Submissions: 53.4K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
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
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    private boolean isString = false;
    private Trie next[] = new Trie[26];
    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for(int i = 0; i < w.length; i++){
            if(root.next[w[i] - 'a'] == null) {
                root.next[w[i] - 'a'] = new Trie();
            }
            root = root.next[w[i] - 'a'];
        }
        root.isString = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for(int i = 0; i < w.length; i++){
            if(root.next[w[i] - 'a'] == null) {
                return false;
            }
            root = root.next[w[i] - 'a'];
        }
        return root.isString;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char w[] = prefix.toCharArray();
        for(int i = 0; i < w.length; i++){
            if(root.next[w[i] - 'a'] == null) {
                return false;
            }
            root = root.next[w[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


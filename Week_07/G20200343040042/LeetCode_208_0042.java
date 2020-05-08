
/**
 * //实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * //
 * // 示例:
 * //
 * // Trie trie = new Trie();
 * //
 * //trie.insert("apple");
 * //trie.search("apple");   // 返回 true
 * //trie.search("app");     // 返回 false
 * //trie.startsWith("app"); // 返回 true
 * //trie.insert("app");
 * //trie.search("app");     // 返回 true
 * //
 * // 说明:
 * //
 * //
 * // 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * // 保证所有输入均为非空字符串。
 * //
 * // Related Topics 设计 字典树
 *
 * @author : Administrator
 * @date : 2020/5/1
 */
public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * 逐个字符判断是否已存在下层连接
     * 存在下层连接: 进入下一层
     * 不存在下层连接: 插入下层连接
     * 当单词所有字符都已插入, 设置终点
     * <p>
     * 复杂度:
     * 时间复杂度: O(m), m为单词的长度
     */
    public void insert(String word) {
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currentKey = word.charAt(i);
            if (!trieNode.containsKey(currentKey)) {
                trieNode.put(currentKey, new TrieNode());
            }
            trieNode = trieNode.getTrieNode(currentKey);
        }
        trieNode.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     * 单词每个字符必须能在路径中,并且单词最后一个字符是终点
     * <p>
     * 复杂度:
     * 时间复杂度: O(m), m为单词的长度
     */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEnd();
    }

    /**
     * 查找树前缀
     *
     * @param prefix
     * @return
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode trieNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (trieNode.containsKey(currentChar)) {
                trieNode = trieNode.getTrieNode(currentChar);
            } else {
                return null;
            }
        }
        return trieNode;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        return trieNode != null;
    }

    public class TrieNode {

        private TrieNode[] links;

        /**
         * 字典树每一个节点对应字母表长度为 字母表长度
         */
        private final int capacity = 26;

        private boolean isEnd = false;

        public TrieNode() {
            links = new TrieNode[capacity];
        }

        /**
         * 判断该节点是否包含该字符
         *
         * @return
         */
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        /**
         * 获取对应的下层节点
         *
         * @param ch
         * @return
         */
        public TrieNode getTrieNode(char ch) {
            return links[ch - 'a'];
        }

        /**
         * 插入下层节点
         *
         * @param ch
         * @param trieNode
         */
        public void put(char ch, TrieNode trieNode) {
            links[ch - 'a'] = trieNode;
        }

        /**
         * 设置结尾
         */
        public void setEnd() {
            isEnd = true;
        }

        /**
         * 获取是否结束
         *
         * @return
         */
        public boolean isEnd() {
            return isEnd;
        }

    }

}

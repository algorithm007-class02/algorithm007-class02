//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board,visited,i,j,result,root);
            }
        }
        return new LinkedList<String>(result);
    }
    public void dfs(char[][] board,boolean[][] visited,int x,int y,Set<String> result,TrieNode cur) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) return;
        cur = cur.children[board[x][y] - 'a'];
        visited[x][y] = true;
        if (cur == null) {
            visited[x][y] = false;
            return;
        }
        if (cur.isEnd) {
            result.add(cur.val);
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(board,visited,newX,newY,result,cur);
        }
        visited[x][y] = false;
    }
}
class Trie {
    public TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char i : word.toCharArray()) {
            if (node.children[i - 'a'] == null) {
                node.children[i - 'a'] = new TrieNode();
            }
            node = node.children[i - 'a'];
        }
        node.isEnd = true;
        node.val = word;
    }
}
class TrieNode {
    public String val;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd = false;
    public TrieNode() {}
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * Set<String> res = new HashSet<>();
 *     int[] dx = {0,0,-1,1};
 *     int[] dy = {-1,1,0,0};
 *     public List<String> findWords(char[][] board, String[] words) {
 *         Trie trie = new Trie();
 *         for (String word : words) {
 *             trie.insert(word);
 *         }
 *         int m = board.length;
 *         int n = board[0].length;
 *         boolean[][] visited = new boolean[m][n];
 *         for (int i = 0; i < m; i++) {
 *             for (int j = 0; j < n; j++) {
 *                 dfs(board,visited,"",i,j,trie);
 *             }
 *         }
 *         return new ArrayList<>(res);
 *     }
 *     public void dfs(char[][] board,boolean[][] visited,String str,int x,int y,Trie trie) {
 *         if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
 *         if (visited[x][y]) return;
 *         str += board[x][y];
 *         if (!trie.startsWith(str)) return;
 *
 *         if (trie.search(str)) res.add(str);
 *         visited[x][y] = true;
 *         for (int i = 0; i < 4; i++) {
 *             int newX = x + dx[i];
 *             int newY = y + dy[i];
 *             dfs(board,visited,str,newX,newY,trie);
 *         }
 *         visited[x][y] = false;
 *     }
 * class Trie {
 *     private final int size = 26;
 *     Trie[] children = new Trie[size];
 *     boolean isEnd = false;
 *     public Trie() {
 *     }
 *
 *     public void insert(String word) {
 *         Trie node = this;
 *         for (char i : word.toCharArray()) {
 *             if (node.children[i - 'a'] == null) {
 *                 node.children[i - 'a'] = new Trie();
 *             }
 *             node = node.children[i - 'a'];
 *         }
 *         node.isEnd = true;
 *     }
 *
 *     public boolean search(String word) {
 *         Trie node = this;
 *         for (char i : word.toCharArray()) {
 *             if (node.children[i - 'a'] == null) {
 *                 return false;
 *             }
 *             node = node.children[i - 'a'];
 *         }
 *         return node.isEnd;
 *     }
 *
 *     public boolean startsWith(String prefix) {
 *         Trie node = this;
 *         for (char i : prefix.toCharArray()) {
 *             if (node.children[i - 'a'] == null) {
 *                 return false;
 *             }
 *             node = node.children[i - 'a'];
 *         }
 *         return true;
 *     }
 * }
 */

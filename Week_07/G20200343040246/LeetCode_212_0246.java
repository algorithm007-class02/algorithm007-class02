package Week_07.G20200343040246;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_212_0246 {
    public static void main(String[] args) {
        String[] words = new String[]{"oath","pea","eat","rain"};
        char[][] board = new char[][]{
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        List<String> res = new LeetCode_212_0246().findWords(board, words);
        for(String str : res) {
            System.out.println(str);
        }
    }

    int[] delta = new int[]{0, 1, 0, -1, 0};
    char[][] board;
    boolean[][] visited;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new LinkedList<>();
        if (words == null || words.length == 0) return res;

        // 构建字典树
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        int m = board.length, n = board[0].length;
        this.board = board;
        this.visited = new boolean[m][n];

        // 回溯匹配
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(root, i, j, new StringBuffer());
            }
        }
        return res;
    }

    private boolean backtrack(Trie root, int i, int j, StringBuffer word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        char cur = board[i][j];
        // 不匹配
        if (visited[i][j] || root.children[cur - 'a'] == null) return false;

        // 标记试探
        visited[i][j] = true;
        word.append(cur);
        // 如果是单词结尾，加入答案
        if (root.children[cur - 'a'].isEnding) {
            res.add(word.toString());
            // 如果该字符是字典树叶子结点，已匹配完，可删除
            if (root.children[cur - 'a'].size == 0) {
                root.children[cur - 'a'] = null;
                // 回溯
                word.setLength(word.length() - 1);
                visited[i][j] = false;
                return --root.size == 0;
            }
        }

        for (int k = 0; k < 4; k++) {
            // 矩形试探
            int x = i + delta[k], y = j + delta[k + 1];
            // cur的字节点已匹配成功且删除，判断cur是否需要删除
            if (backtrack(root.children[cur - 'a'], x, y, word)) {
                // 只有cur一个字节点，删除cur
                if (root.children[cur - 'a'].size == 0) {
                    root.children[cur - 'a'] = null;
                    // 回溯
                    word.setLength(word.length() - 1);
                    visited[i][j] = false;
                    return --root.size == 0;
                }
            }
        }
        // 回溯
        word.setLength(word.length() - 1);
        visited[i][j] = false;

        if (root.children[cur - 'a'].isEnding) root.children[cur - 'a'].isEnding = false;
        return false;
    }
}

class Trie {
    int size;
    boolean isEnding;
    Trie[] children = new Trie[26];

    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        Trie temp = this;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
                temp.size++;
            }
            temp = temp.children[c - 'a'];
        }
        temp.isEnding = true;
    }
}
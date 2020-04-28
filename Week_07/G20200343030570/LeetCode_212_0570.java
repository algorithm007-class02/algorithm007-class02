class Trie {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[R];
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!node.containsKey(c))
                node.put(c, new TrieNode());
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if(node.containsKey(c))
                node = node.get(c);
            else 
                return null;
        }
        return node;
    }
}

class Solution {
    private char[][] _board = null;
    private List<String> result = new ArrayList();
    public List<String> findWords(char[][] board, String[] words) {
        // 用words里所有单词构建字典树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (!node.link.containsKey(letter))
                    node.link.put(letter, new TrieNode());
                node = node.link.get(letter);
            }
            node.word = word;
        }
        
        this._board = board;
        
        for (int row = 0; row < board.length; ++row)
            for (int col = 0; col < board[row].length; ++col)
                //
                if (root.link.containsKey(board[row][col]))
                    backtracking(row, col, root);
        
        return this.result;
    }
    
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.link.get(letter);
        // 已找到完整单词
        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }
        // 避免重复访问
        this._board[row][col] = '#';
        
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            
            // 判断是否越界
            if (newRow < 0 || newRow >= this._board.length ||
                newCol < 0 || newCol >= this._board[0].length)
                continue;
            
            if (currNode.link.containsKey(this._board[newRow][newCol]))
                backtracking(newRow, newCol, currNode);
        }
        // 还原
        this._board[row][col] = letter;
        
        if (currNode.link.isEmpty())
            parent.link.remove(letter);
    }
}

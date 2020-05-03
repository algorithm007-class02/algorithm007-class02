class Trie {
    Trie[] nodeList;
    boolean isEnd = false;
    int nodeMaxWidth = 26;
    /** Initialize your data structure here. */
    public Trie() {
        nodeList = new Trie[nodeMaxWidth];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nodeList[c - 'a'] == null) {
                Trie t = new Trie();
                node.nodeList[c - 'a'] = t;
            }
            node = node.nodeList[c - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nodeList[c - 'a']!= null) {
                node = node.nodeList[c - 'a'];
            }else
            {
                return false;
            }
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.nodeList[c - 'a']!= null) {
                node = node.nodeList[c - 'a'];
            }else
            {
                return false;
            }
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
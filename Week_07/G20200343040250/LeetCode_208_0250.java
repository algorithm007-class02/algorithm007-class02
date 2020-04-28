class Trie {
    private final int SIZE = 26;
    private Trie[] childern = new Trie[SIZE];
    boolean isEnd = false;

    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (char c: word.toCharArray()) {
            if (curr.childern[c - 'a'] == null) {
                curr.childern[c - 'a'] = new Trie();
            }
            curr = curr.childern[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.childern[c - 'a'] == null) {
                return false;
            }
            curr = curr.childern[c - 'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.childern[c - 'a'] ==  null) {
                return false;
            }
            curr = curr.childern[c - 'a'];
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

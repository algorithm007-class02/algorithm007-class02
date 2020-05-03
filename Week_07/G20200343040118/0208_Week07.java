class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char []chars = word.toCharArray();
        for(char temp : chars){
            if(!node.containsKey(temp)){
                node.put(temp,new TrieNode());
            }
            node = node.get(temp);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix( word);
        return node != null && node.isEnd();
    }
    TrieNode searchPrefix(String word){
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char temp : chars){
            if(!node.containsKey(temp))
                return null;
            node = node.get(temp);
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    class TrieNode{
        TrieNode[] links;
        final int R = 26;
        boolean isEnd;
        public TrieNode(){
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }
        public TrieNode get(char ch){
            return links[ch - 'a'];
        }
        public void put(char ch , TrieNode node){
            links[ch - 'a'] = node;
        }
        public void setEnd(){
            isEnd =true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
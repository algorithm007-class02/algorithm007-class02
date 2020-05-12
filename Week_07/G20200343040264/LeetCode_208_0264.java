class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (!node.containKey(key)) {
                node.put(key,new TrieNode());
            }
            node = node.get(key);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.containKey(prefix.charAt(i))) {
                node = node.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}


class TrieNode {
    private TrieNode[] links;

    private boolean isEnd = false;

    public TrieNode () {
        links = new TrieNode[26];
    }

    public boolean containKey(char key) {
        return links[key - 'a'] != null;
    }

    public TrieNode get(char key) {
        return links[key - 'a'];
    }

    public void put(char key, TrieNode trieNode) {
        links[key - 'a'] = trieNode;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
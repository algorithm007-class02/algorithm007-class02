class Trie {
    bool isEnd_;
    Trie* next_[26];
public:
    /** Initialize your data structure here. */
    Trie() :isEnd_(false), next_{0}{

    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* node = this;
        for (char c : word) {
            if (node->next_[c - 'a'] == nullptr) {
                node->next_[c - 'a'] = new Trie();
            }
            node = node->next_[c - 'a'];
        }
        node->isEnd_ = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* node = this;
        for (char c : word) {
            node = node->next_[c - 'a'];
            if (node == nullptr) {
                return false;
            }
        }
        return node->isEnd_;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* node = this;
        for (char c : prefix) {
            node = node->next_[c- 'a'];
            if (node == nullptr) {
                return false;
            }
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
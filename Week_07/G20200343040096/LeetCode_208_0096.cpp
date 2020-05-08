class Trie {

private:
    Trie* next[26] = {};
    bool isEnd = false;

public:
    /** Initialize your data structure here. */
    Trie() {

    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* node = this;
        for(auto w : word){
            if(!node->next[w - 'a']){
                node->next[w - 'a'] = new Trie();
            }
            node = node->next[w - 'a'];
        }
        node->isEnd = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* node = this;
        for(auto w : word){
            if(!node->next[w - 'a']) return false;
            node = node->next[w - 'a'];
        }
        return node->isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* node = this;
        for(auto w : prefix){
            if(!node->next[w - 'a']) return false;
            node = node->next[w - 'a'];
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

class Trie {
private:
    bool isEnd=false;
    Trie* next[26]={nullptr};   
public:
    /** Initialize your data structure here. */
    Trie() {

    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* root=this;
        for (int i=0;i<word.size();++i) {
            if (root->next[word[i]-'a']==nullptr) root->next[word[i]-'a']=new Trie();
            root=root->next[word[i]-'a'];
        }
        root->isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* root=this;
        for (char ch:word) {
            if (root->next[ch-'a']==nullptr) return false;
            root=root->next[ch-'a'];
        }
        return root->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* root=this;
        for (char ch:prefix) {
            if (root->next[ch-'a']==nullptr) return false;
            root=root->next[ch-'a']; 
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
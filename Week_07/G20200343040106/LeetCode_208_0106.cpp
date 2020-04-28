class Trie {
public:
    struct TrieNode{
        unordered_map<char,TrieNode*> record;
        bool isWord;
        TrieNode():isWord(false){}
    };
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* cur = root;
        for(int i=0;i<word.size();i++){
            if(!cur->record[word[i]]){
                TrieNode* next = new TrieNode();
                cur->record[word[i]] = next;
            }
            cur = cur->record[word[i]];
        }
        cur->isWord = true;
        return ;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* cur = root;
        for(int i=0;i<word.size();i++){
            if(cur->record[word[i]]){
                cur = cur->record[word[i]];
            }else return false;
        }

        return cur->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* cur = root;
        for(int i=0;i<prefix.size();i++){
            if(cur->record[prefix[i]]){
                cur = cur->record[prefix[i]];
            }else return false;
        }
        return true;
    }
private:
    TrieNode* root;
};

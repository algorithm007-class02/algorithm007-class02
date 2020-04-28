class Solution {
public:
    struct TrieNode{
        unordered_map<char,TrieNode*> record;
        bool isWord;
        string word;
        TrieNode():isWord(false),word(""){}
    };
    TrieNode* buildTrie(vector<string>& words){
        TrieNode* root = new TrieNode();
        for(int i=0;i<words.size();++i){
            TrieNode* cur = root;
            for(int j=0;j<words[i].size();j++){
                if(cur->record[words[i][j]]==NULL){
                    cur->record[words[i][j]] = new TrieNode();
                }
                cur = cur->record[words[i][j]];
            }
            cur->isWord = true;
            cur->word = words[i];
        }
        return root;
    }
public:
    set<string> ans; 
    int m,n;
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        m = board.size();
        n = board[0].size();
        // build Trie from words
        TrieNode* root = buildTrie(words);
        //dfs
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                traceBack(board,i,j,root);
            }
        }

        return vector(ans.begin(),ans.end());
    }
    void traceBack(vector<vector<char>>& board,int i,int j,TrieNode* cur){
        if(i<0||j<0||i>=m||j>=n) return ;
        char c = board[i][j];
        if(c=='#'||cur->record[c]==NULL) return ;
        cur = cur->record[c];
        if(cur->isWord){
            ans.insert(cur->word);
        }
        board[i][j] = '#';
        traceBack(board,i - 1, j,cur); 
        traceBack(board,i, j - 1,cur); 
        traceBack(board,i + 1, j,cur); 
        traceBack(board,i, j + 1,cur); 
        board[i][j] = c;
        return ;
    }
};
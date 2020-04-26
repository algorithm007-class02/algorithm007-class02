// word search Ⅰ

class Solution {
public:
    int m,n;
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        if(m==0) return false;
        n = board[0].size();
        if(n==0) return false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,0,word)) return true;
            }
        }
        return false;
    }

    bool dfs(vector<vector<char>>& board,int i,int j,int k,string &s){
        if(k>=s.size()){
            return true;
        }
        if(i<0||i>=m||j<0||j>=n||board[i][j]!=s[k]) return false;
        char c = board[i][j];
        board[i][j] ='#';
        bool ret = dfs(board,i+1,j,k+1,s)||dfs(board,i,j+1,k+1,s)||dfs(board,i-1,j,k+1,s)||dfs(board,i,j-1,k+1,s);
        board[i][j] =c;

        return ret;
    }

};
class Solution {
public:
    vector<vector<string>> ans;
    vector<string> nQueens;
    vector<vector<string>> solveNQueens(int n) {
        nQueens=vector<string> (n,string(n,'.'));
        vector<int> flag_col(n,1),flag_45(2*n-1,1),flag_135(2*n-1,1);
        solveNQueens(nQueens,flag_col,flag_45,flag_135,0,n);
        return ans;
    }

    void solveNQueens(vector<string>& nQueens,vector<int>& flag_col,vector<int>& flag_45,vector<int>& flag_135,int level,int n) {
     if (level==n) {
         ans.push_back(nQueens);
         return;
     }   
     for (int col=0;col!=n;++col) {
         if (flag_col[col]&&flag_45[level+col]&&flag_135[n-1+level-col]) {
             flag_col[col]=flag_45[level+col]=flag_135[n-1+level-col]=0;
             nQueens[level][col]='Q';
             solveNQueens(nQueens,flag_col,flag_45,flag_135,level+1,n);
             nQueens[level][col]='.';
             flag_col[col]=flag_45[level+col]=flag_135[n-1+level-col]=1;
         }
     }
    }
};
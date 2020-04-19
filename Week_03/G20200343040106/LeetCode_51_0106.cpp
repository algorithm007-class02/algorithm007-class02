#include<vector>
#include<string>
using namespace std;

class Solution {
public:
    vector<bool> col;      //竖 有没有已经存在了。
    vector<bool> posdia;   // 正对角线 
    vector<bool> negdia;   // 反对角线
    vector<vector<string>> ans;
    vector<vector<string>> solveNQueens(int n) {
        col = vector<bool>(n,false);
        posdia = vector<bool>(2*n,false);
        negdia = vector<bool>(2*n,false);
        vector<int> curstate;
        traceBack(curstate,0,n);
        return ans;
    }

    void traceBack(vector<int>& state,int level,int n){
        // terminator
        if(level==n){
            addSolution(state,n);
            return ;
        }
        // process cur level
        for(int i=0;i<n;i++){
            if(!hasConflict(level,i,n)){
                col[i] = true;
                posdia[level+i] = true;
                negdia[level-i+n] = true;
                state.push_back(i);
                // drill down
                traceBack(state,level+1,n);
                // reverse state
                state.pop_back();
                col[i] = false;
                posdia[level+i] = false;
                negdia[level-i+n] = false;
            }
        }
    }
    bool hasConflict(int x,int y,int n){
        return col[y]||posdia[x+y]||negdia[x-y+n];
    }
    void addSolution(vector<int>& state,int n){
        vector<string> res= vector<string>(n,string(n,'.'));
        for(int i=0;i<n;i++){
            res[i][state[i]] = 'Q';
        }
        ans.push_back(res);
    }
};
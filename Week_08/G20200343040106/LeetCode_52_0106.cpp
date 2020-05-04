class Solution {
public:
    int ans;
    int totalNQueens(int n) {
        ans = 0;
        dfs(0,n,0,0,0);
        return ans;
    }

    void dfs(int curLevel,int n,int col,int pie,int na) {
        if(curLevel >= n) {
            ans++;
            return ;
        }

        int empty = ~(col|pie|na) & ((1<<n)-1);
        while(empty) {
            int p = empty & -empty; // 取最后位置的1
            empty = empty&(empty-1); //最后位置放上皇后
            dfs(curLevel+1,n,col|p,(pie|p)<<1,(na|p)>>1);
        }
    }
};
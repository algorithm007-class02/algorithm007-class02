class Solution {
public:
    int ans=0;
    int totalNQueens(int n) {
        dfs(n,0,0,0,0);
        return ans;
    }
    void dfs(int n,int row,int col,int ld,int rd) {
        if (row>=n){ans++;return;}
        int bits= ~(col|ld|rd)&((1<<n)-1);
        while (bits>0) {
            int pick=bits&-bits;
            dfs(n,row+1,col|pick,(ld|pick)<<1,(rd|pick)>>1);
            bits = bits&(bits-1);
        }
    }
};
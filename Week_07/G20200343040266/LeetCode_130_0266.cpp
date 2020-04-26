class UnionFind{
private:
    vector<int> parent;
public:
    UnionFind(int n) {
        parent.resize(n);
        for (int i=0;i<n;++i) {
            parent[i]=i;
        }
    }
    void Union(int p,int q) {
        int rootP=find(p);
        int rootQ=find(q);
        if (rootP!=rootQ) {
            parent[rootQ]=rootP;
        }
    }
    int find(int p) {
        while (parent[p]!=p) {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    bool isConnected(int p,int q) {
        return find(p)==find(q);
    }
};
class Solution {
public:
    int cols;
    void solve(vector<vector<char>>& board) {
        int rows=board.size();
        if (rows==0) return;
        cols=board[0].size();
        UnionFind uf(rows*cols+1);
        int dummyNode=rows*cols;

        for (int i=0;i<rows;++i) {
            for (int j=0;j<cols;++j) {
                if (board[i][j]=='O') {
                    if (i==0||j==0||i==rows-1||j==cols-1) {
                        uf.Union(node(i,j),dummyNode);
                    } else {
                        if (i>0&&board[i-1][j]=='O') uf.Union(node(i,j),node(i-1,j));
                        if (i<rows-1&&board[i+1][j]=='O') uf.Union(node(i,j),node(i+1,j));
                        if (j>0&&board[i][j-1]=='O') uf.Union(node(i,j),node(i,j-1));
                        if (j<cols-1&&board[i][j+1]=='O') uf.Union(node(i,j),node(i,j+1));
                    }
                }
            }
        }

        for (int i=0;i<rows;++i) {
            for (int j=0;j<cols;++j) {
                if (uf.isConnected(node(i,j),dummyNode)) {
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }
    }

    int node(int i,int j) {
        return i*cols+j;
    }
};
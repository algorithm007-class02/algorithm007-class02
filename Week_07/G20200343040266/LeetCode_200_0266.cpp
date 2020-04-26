class UnionFind {
private:
    vector<int> parent;
public:
    int count=0;
    UnionFind(vector<vector<char>>& grid) {
        int r=grid.size(),c=grid[0].size();
        parent.resize(r*c);
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;++j) {
                if (grid[i][j]=='1') {parent[i*c+j]=i*c+j;count++;}
                else parent[i*c+j]=0;
            }
        }
    }

    int find (int p) {
        while (p!=parent[p]) {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }

    void Union(int p,int q) {
        int rootP=find(p);
        int rootQ=find(q);
        if (rootP==rootQ) return;
        parent[rootP]=rootQ;
        count--;
    }
};
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int r=grid.size();
        if (r==0) return 0;
        int c=grid[0].size();
        
        UnionFind Unio(grid);
        for (int i=0;i<r;++i) {
            for (int j=0;j<c;++j) {
                if (grid[i][j]=='1') {
                    grid[i][j]='0';
                    if (i-1>=0&&grid[i-1][j]=='1') Unio.Union(i*c+j,(i-1)*c+j);
                    if (i+1<r&&grid[i+1][j]=='1') Unio.Union(i*c+j,(i+1)*c+j);
                    if (j-1>=0&&grid[i][j-1]=='1') Unio.Union(i*c+j,i*c+j-1);
                    if (j+1<c&&grid[i][j+1]=='1') Unio.Union(i*c+j,i*c+j+1);
                }
            }
        }
        return Unio.count;
    }
};
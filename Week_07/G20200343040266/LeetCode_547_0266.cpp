class UnionFind {
private:
    vector<int> parent;
public:
    int count=0;
    UnionFind(int n) {
        count=n;
        parent.resize(n);
        for (int i=0;i<n;++i) {
            parent[i]=i;        
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
    int findCircleNum(vector<vector<int>>& M) {
        int n=M.size();
        UnionFind unioSet(n);
        for (int i=0;i<n;++i) {
            for (int j=i+1;j<n;++j) {
                if (M[i][j]==1) unioSet.Union(i,j);
            }
        }
        return unioSet.count;
    }
};
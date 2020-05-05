class Solution {
private:
    int count = 0;
public:
    int find_root(int x, vector<int> parent){
        int root = x;
        while(parent[root] != -1){
            root = parent[root];
        }
        return root;
    }

    int union_set(int x, int y, vector<int>& parent){
        int x_root = find_root(x, parent);
        int y_root = find_root(y, parent);
        if(x_root != y_root){
            parent[y_root] = x_root;
            --count;
        }
        return x_root;
    }

    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size();
        vector<int> parent(n, -1);
        count = n;
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                if(M[i][j] == 1){
                    union_set(i, j, parent);
                }
            }
        }
        return count;
    }
};

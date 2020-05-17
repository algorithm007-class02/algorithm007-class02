class DisJointSet {
private:
    vector<int> parent;
    vector<int> rank;
    int count;

public:
    DisJointSet(vector<vector<char>>& grid) {
        count = 0;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    parent.push_back(i * n + j);
                    ++count;
                }
                else {
                    parent.push_back(-1);
                }
                rank.push_back(0);
            }
        }
    }

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    void union_set(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if(x_root == y_root) return;
        if (rank[x_root] > rank[y_root]) {
            parent[y_root] = x_root;
        }else{
            parent[x_root] = y_root;
            if (rank[x_root] == rank[y_root])
                ++rank[y_root];
        }
        --count;
    }

    int getCount() const {
        return count;
    }
};
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        if(n == 0) return 0;
        int m = grid[0].size();
        DisJointSet djs (grid);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i-1][j] == '1') djs.union_set(i * m + j, (i-1) * m + j);
                    if (i + 1 < n && grid[i+1][j] == '1') djs.union_set(i * m + j, (i+1) * m + j);
                    if (j - 1 >= 0 && grid[i][j-1] == '1') djs.union_set(i * m + j, i * m + j - 1);
                    if (j + 1 < m && grid[i][j+1] == '1') djs.union_set(i * m + j, i * m + j + 1);
                }
            }
        }
        return djs.getCount();
    }
};

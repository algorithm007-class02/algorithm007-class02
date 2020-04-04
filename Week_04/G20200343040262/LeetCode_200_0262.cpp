//mark the island
class Solution {
private:
    int row;
    int col;
public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        row = grid.size();
        if (row == 0) return res;
        col = grid[0].size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    Mark(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void Mark(vector<vector<char>>& grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        grid[i][j] = '0';
        Mark(grid, i + 1, j);
        Mark(grid, i - 1, j);
        Mark(grid, i, j + 1);
        Mark(grid, i, j - 1);
    }
};
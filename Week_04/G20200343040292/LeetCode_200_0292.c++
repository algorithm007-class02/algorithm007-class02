/*
广度优先搜索
时间复杂度：O(M×N)
空间复杂度：O(min(M,N))
*/
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int row_count = grid.size();
        if (!row_count)
            return 0;
        int col_count = grid[0].size();
        int count = 0;
        
        for (int i = 0; i < row_count; i++) {
            for (int j = 0; j < col_count; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue<pair<int ,int>> q;
                    q.push({i, j});
                    while (!q.empty()) {
                        auto node = q.front();
                        q.pop();
                        int row = node.first;
                        int col = node.second;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            q.push({row-1, col});
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < row_count && grid[row+1][col] == '1') {
                            q.push({row+1, col});
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            q.push({row, col-1});
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < col_count && grid[row][col+1] == '1') {
                            q.push({row, col+1});
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
};
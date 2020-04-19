class Solution {
    vector<vector<bool>> visited;  // 初始化visited
    vector<vector<int>>  directiron;
    int rows;
    int cols;
public:

    Solution() :directiron({ {-1,0}, {0,-1}, {1, 0}, {0, 1}})
    {

    }
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0) return 0;

        directiron.push_back({-1,0});
        directiron.push_back({0,-1});
        directiron.push_back({1, 0});
        directiron.push_back({0, 1});
        
        //int directiron[][2] = { {-1,0}, {0,-1}, {1, 0}, {0, 1}} ;//方向数组
        rows = grid.size();
        cols = grid[0].size();

        
        for ( int i = 0; i < rows; i++) {
            visited.push_back({});
            for (int j = 0; j < grid[i].size(); j++) {
                visited[i].push_back(false);
            }
        }

        int count = 0;

        for ( int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++) {
                if ( !visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    void dfs(int i, int j, vector<vector<char>>& grid) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newx = i + directiron[k][0];
            int newy = j + directiron[k][1];

            if (inAera(newx, newy) && grid[newx][newy] == '1' && !visited[newx][newy]) {
                dfs(newx, newy, grid);
            }
        }
    }

    bool inAera(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

};


// 方法2： DFS
class Solution {
    int rows;
    int cols;
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;

        vector<vector<char>> gridcopy = grid;
        int count = 0;
        rows = gridcopy.size();
        cols = gridcopy[0].size();

        for (int i = 0; i < gridcopy.size(); i++) {
            for (int j = 0; j < gridcopy[i].size(); j++) {
                if (gridcopy[i][j] == '1') {
                    count++;
                    dfs(gridcopy, i, j);
                }
            }
        }

        return count;
    }

    void dfs(vector<vector<char>>& gridcopy, int x, int y) {
        // 1. terminator
        if (x < 0 || x == rows || y < 0 || y == cols || gridcopy[x][y] == '0') return;

        // 2. process
        int inx[4] = {-1, 1, 0, 0};
        int iny[4] = {0,  0, 1,-1};

        gridcopy[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            // 3. drill
            dfs(gridcopy, x + inx[i], y + iny[i]);
        }
    }
};


// 方法3：
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;
        
        vector<vector<char>> gridCopy = grid;
        int rows = grid.size();
        int cols = grid[0].size();

        int inX[] = {0, 0, 1, -1};
        int inY[] = {-1, 1, 0, 0};

        int count = 0;
        for ( int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++) {
                    if (gridCopy[i][j] == '1') {
                        count++;
                        queue<pair<int, int>> queueHelp;
                        queueHelp.push(make_pair(i, j));
                        gridCopy[i][j] = '0';
                        while(!queueHelp.empty()) {
                            pair<int, int> p = queueHelp.front();
                            queueHelp.pop();

                            for (int k = 0; k < 4; k++) {
                                int newx = p.first + inX[k];
                                int newy = p.second + inY[k];

                                if (newx >= 0 && newx < rows && newy >= 0 && newy < cols && gridCopy[newx][newy] == '1') {
                                    gridCopy[newx][newy] = '0';
                                    queueHelp.push(pair(newx, newy));
                                }
                            }
                        }

                    }
            }
        }

        return count;
    }
};
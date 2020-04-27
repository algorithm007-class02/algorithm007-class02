class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;

        int x[4] = {0, -1, 1, 0};
        int y[4] = {1, 0, 0, -1};

        vector<vector<char>> gridtemp = grid;
        int length = gridtemp.size();
        int height = gridtemp[0].size();

        int num = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < height; ++j) {
                if (gridtemp[i][j] == '1') {
                    // 进行bfs搜索
                    num++;
                    gridtemp[i][j] = '0';

                    queue<pair<int, int>> queuehelper;
                    queuehelper.push(make_pair(i, j));

                    while(!queuehelper.empty()) {
                        pair<int, int> p = queuehelper.front();
                        queuehelper.pop();

                        for (int i = 0; i < 4; i++) {
                            int xleft = p.first + x[i];
                            int yright = p.second + y[i];
                            if (xleft >= 0 && xleft < length && yright >= 0 && yright < height && gridtemp[xleft][yright] == '1') {
                                gridtemp[xleft][yright] = '0';
                                queuehelper.push(make_pair(xleft, yright));
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
};

// bfs
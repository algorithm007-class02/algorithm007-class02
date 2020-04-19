class Solution {
public:
    struct PositionHash
    {
        size_t operator()(const pair<int, int> &val) const
        {
            return val.first ^ val.second;
        }
    };
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        unordered_set<pair<int, int>, PositionHash> obstacleSet;
        for (vector<int> obstacle: obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));
        int res = 0;
        for (int cmd : commands) {
            if (cmd == -2) di = (di + 3) % 4;//左转
            else if (cmd == -1) di = (di + 1) % 4;//右转
            else {
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end()) {
                        //未被阻碍
                        x = nx;
                        y = ny;
                        res = max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
};
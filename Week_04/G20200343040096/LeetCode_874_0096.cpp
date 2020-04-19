class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int res = 0, x = 0, y = 0, dir = 0;
        set<pair<int, int>> us;
        for(auto obstacle : obstacles){
            us.insert(make_pair(obstacle[0], obstacle[1]));
        }
        for(auto cmd : commands){
            if(cmd == -2){
                dir = (dir + 3) % 4;
            }else if(cmd == -1){
                dir = (dir + 1) % 4;
            }else if(cmd >= 1 && cmd <= 9){
                for(int i = cmd; i > 0; --i){
                    if(us.find(make_pair(x + dx[dir], y + dy[dir])) == us.end()){
                        x += dx[dir];
                        y += dy[dir];
                        res = std::max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
};

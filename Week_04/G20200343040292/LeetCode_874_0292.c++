/*
̰�ķ�
ʱ�临�Ӷȣ�O(N + K) ���� N, KN,K �ֱ��� commands �� obstacles �ĳ��ȡ�
�ռ临�Ӷȣ�O(K) ���ڴ洢 obstacleSet ��ʹ�õĿռ䡣
*/
class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int x = 0, y = 0, dir = 0;
        int ans = 0;
        int dx[4] = {0, -1, 0, 1};
        int dy[4] = {1, 0, -1, 0};
        unordered_set< string > obstacles_set;
        
        for (vector<int> obstacle : obstacles) {
            string s = to_string(obstacle[0]) + " " + to_string(obstacle[1]);
            obstacles_set.insert(s);
        }

        for (auto command : commands) {
            if (command == -2)
                dir = (dir + 1) % 4;
            else if (command == -1)
                dir = (dir + 3) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    int foot_x = x + dx[dir];
                    int foot_y = y + dy[dir];
                    string s = to_string(foot_x) + " " + to_string(foot_y);
                    if (obstacles_set.find(s) == obstacles_set.end()) {
                        x = foot_x;
                        y = foot_y;
                        ans = max(ans, x*x + y*y);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
};
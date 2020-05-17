/*
 * @lc app=leetcode.cn id=773 lang=cpp
 *
 * [773] 滑动谜题
 */

// @lc code=start
/**
 * 对于每个节点，定义一个预估代价 node.priority = node.depth + node.heuristic
 * 其中 node.depth 为已经走过的距离，node.heuristic 为预估的剩余距离
 * */
// 预估距离采用曼哈顿距离
/**变换向量
 * moves = {
 * 0: [1, 3]
 * 1: [0, 2, 4]
 * 2: [1, 5]
 * 3: [0, 4]
 * 4: [1, 3, 5]
 * 5: [2, 4]
 * }
 * */
class Solution {
public:
    int slidingPuzzle(vector<vector<int>> &board) {
        int row = board.size(), col = board[0].size();
        string target = "123450";
        string begin;
        // 将二维数组转化为一维数组并存进字符串
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                begin += to_string(board[i][j]);
            }
        }
        // 方向数组
        vector<vector<int>> nextMoves{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        unordered_set<string> visited{begin};
        queue<string> q;
        q.push(begin);
        for (int depth = 0; !q.empty(); ++depth) {
            int size = (int)q.size();
            for (int i = 0; i < size; ++i) {
                auto curr = q.front();
                q.pop();
                if (curr == target) {
                    return depth;
                }
                // 0 所在下标，注意题目中只能移动0啊
                int zero_index = (int)curr.find("0");
                for (auto next : nextMoves[zero_index]) {
                    auto candidate = curr;
                    // 移动0
                    swap(candidate[zero_index], candidate[next]);
                    // 若未访问过，则入队
                    if (visited.find(candidate) == visited.end()) {
                        visited.insert(candidate);
                        q.push(candidate);
                    }
                }
            }
        }
        return -1;
    }
};
// @lc code=end

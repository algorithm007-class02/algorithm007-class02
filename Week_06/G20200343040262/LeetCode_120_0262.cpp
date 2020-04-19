//自顶向下递归 + 记忆化搜索
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if (triangle.size() == 0) return 0;
        vector<vector<int>> cache(triangle.size(), vector<int>(triangle.size(), 0));
        return helper(0, 0, triangle, cache);
    }

    int helper(int row, int col, vector<vector<int>> triangle, vector<vector<int>> cache) {
        //terminator
        if (row + 1 >= triangle.size()) {
            return triangle[row][col];
        }
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        //drill down
        int left = helper(row + 1, col, triangle, cache);
        int right = helper(row + 1, col + 1, triangle, cache);
        cache[row][col] = min(left, right) + triangle[row][col];
        return cache[row][col];
    }
};
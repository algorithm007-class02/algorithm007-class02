/*
 * @lc app=leetcode.cn id=85 lang=cpp
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
public:
    int maximalRectangle(vector<vector<char>> &matrix) {
        if (matrix.size() == 0)
            return 0;
        int maxArea = 0;
        int cols = matrix[0].size();
        vector<int> leftLessMin(cols, -1);
        vector<int> rightLessMin(cols, cols);
        vector<int> heights(cols);
        for (int row = 0; row < matrix.size(); ++row) {
            // 更新所有高度
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }
            // 更新所有leftLessMin
            int boundary = -1; // 记录上次出现0的位置
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] == '1') {
                    // 和上次出现0的位置比较
                    leftLessMin[col] = max(leftLessMin[col], boundary);
                } else {
                    // 初始化为-1
                    leftLessMin[col] = -1;
                    boundary = col; // 更新0的位置
                }
            }
            // 右边同理
            boundary = cols;
            for (int col = cols - 1; col >= 0; --col) {
                if (matrix[row][col] == '1') {
                    // 和上次出现0的位置比较
                    rightLessMin[col] = min(rightLessMin[col], boundary);
                } else {
                    // 初始化为-1
                    rightLessMin[col] = cols;
                    boundary = col; // 更新0的位置
                }
            }
            // 更新所有面积
            for (int col = cols - 1; col >= 0; --col) {
                int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                maxArea = max(area, maxArea);
            }
        }
        return maxArea;
    }
};
// @lc code=end

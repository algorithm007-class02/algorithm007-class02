class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty()) {
            return false;
        }
        int rows = matrix.size();
        int cols = matrix[0].size();

        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + ((right - left)>>1);
            int i = mid / cols;
            int j = mid % cols;

            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
};

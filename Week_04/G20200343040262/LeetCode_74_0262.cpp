class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size() == 0) return false;
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = m - 1;
        int flag = 0;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) high = mid - 1;
            else {
                if (target <= matrix[mid][n - 1]) {
                    flag = 1;
                    break;
                }
                else low = mid + 1;
            }
        }
        if (flag == 1) {
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (matrix[mid][m] == target) return true;
                else if (matrix[mid][m] > target) r = m - 1;
                else l = m + 1;
            }
        }
        return false;
    }
};
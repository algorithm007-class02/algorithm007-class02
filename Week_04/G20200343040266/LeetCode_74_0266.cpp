class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size()==0||matrix[0].size()==0) return false;
        int row=matrix.size(),colum=matrix[0].size();
        
        //先找到目标数字若存在的话，属于的行;则找到第一列组成的升序序列中，最后一个小于等于target的
        int row_left=0,row_right=row-1;
        int r;
        while (row_left<=row_right) {
            int row_mid=row_left+((row_right-row_left)>>1);
            if (matrix[row_mid][0]>target) {
                row_right=row_mid-1;
            } else {
                    if (row_mid==row-1||matrix[row_mid+1][0]>target) {r=row_mid;break;}
                    else row_left=row_mid+1;
            }
        }

        int left=0,right=matrix[r].size()-1;
        while (left<=right) {
            int mid=left+(right-left)/2;
            if (matrix[r][mid]==target) return true;
            if (matrix[r][mid]>target) right=mid-1;
            else if (matrix[r][mid]<target) left=mid+1;
        }
        return false;
    }
};
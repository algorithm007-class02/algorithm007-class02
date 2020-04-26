class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size()==0) return 0;
        int rows=grid.size(),colums=grid[0].size();
        vector<vector<int>> memo (rows,vector<int>(colums,-1));
        return helper(grid,memo,0,0);
    }

    int helper(vector<vector<int>>& grid,vector<vector<int>>& memo,int i,int j) {
        if (memo[i][j]!=-1) return memo[i][j];
        if (i==grid.size()-1&&j==grid[0].size()-1) {return memo[i][j]=grid[i][j];}

        if (i==grid.size()-1) {
            return memo[i][j]=helper(grid,memo,i,j+1)+grid[i][j];
        } else if (j==grid[0].size()-1) {
            return memo[i][j]=helper(grid,memo,i+1,j)+grid[i][j];
        } else {
            return memo[i][j]=grid[i][j]+min(helper(grid,memo,i+1,j),helper(grid,memo,i,j+1));
        }

        return -1;
    }
};
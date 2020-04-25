/*
200. 岛屿数量
*/

class Solution {
public:
    void helper(int i, int j, vector<vector<char>>& grid)
    {
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[i].size() || '0' == grid[i][j])
        {
            return;
        }

        grid[i][j] = '0';

        helper(i-1, j, grid);
        helper(i, j-1, grid);
        helper(i+1, j, grid);
        helper(i, j+1, grid);

        return;
    }

    int numIslands(vector<vector<char>>& grid) 
    {
        int count = 0;
        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j < grid[i].size(); j++)
            {
                if('1' == grid[i][j])
                {
                    count++;
                    helper(i, j, grid);
                }
            }
        }
        
        return count;
    }
};
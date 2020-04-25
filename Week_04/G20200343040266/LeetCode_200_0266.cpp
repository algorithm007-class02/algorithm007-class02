class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size()==0) return 0;
        int count=0;
        int row=grid.size(),colum=grid[0].size();
        for (int i=0;i<row;++i) {
            for (int j=0;j<colum;++j) {
                if (grid[i][j]=='1') {
                    count++;
                    dfs(i,j,row,colum,grid);
                }
            }
        }
        return count;
    }

    void dfs(int i,int j,int row,int colum,vector<vector<char>>& grid) {
        grid[i][j]='0';
        if (i-1>=0&&grid[i-1][j]=='1') dfs(i-1,j,row,colum,grid);
        if (i+1<row&&grid[i+1][j]=='1') dfs(i+1,j,row,colum,grid);
        if (j-1>=0&&grid[i][j-1]=='1') dfs(i,j-1,row,colum,grid);
        if (j+1<colum&&grid[i][j+1]=='1') dfs(i,j+1,row,colum,grid); 
    }
};
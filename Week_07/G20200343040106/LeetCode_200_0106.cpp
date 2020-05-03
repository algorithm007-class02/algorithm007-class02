class Solution {
public:
    class MyUF{
    public:
        MyUF(int count){
            this->count = count;
            parent = (int*)malloc(count*sizeof(int));
            for(int i=0;i<count;i++)
                parent[i] = i;
        }
        void Union(int kid1,int kid2){
            int p1 = find(kid1);
            int p2 = find(kid2);
            if(p1==p2) return ;
            parent[p1] = p2;
            return ;
        }

        int find(int kid){
            int root = kid;
            while(root!=parent[root]){
                root = parent[root];
            }
            // 路径压缩
            while(kid!=parent[kid]){
                int temp = parent[kid];
                parent[kid] = root;
                kid = temp;
            }
            return root;
        }
        int circleNum(){
            set<int> s;
            for(int i=0;i<count-1;i++){
                if(parent[i]==i)
                    s.insert(parent[i]);
            }
            return s.size();
        }
    private:
        int count;
        int *parent;
    };
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        if(m==0) return 0;
        int n = grid[0].size();
        if(n==0) return 0;

        MyUF UF(m*n+1);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0'){
                    UF.Union(i*n+j,m*n);
                }else if(grid[i][j]=='1'){
                    if(i-1>=0&&grid[i-1][j]=='1') UF.Union(i*n+j,(i-1)*n+j);
                    if(i+1<m&&grid[i+1][j]=='1') UF.Union(i*n+j,(i+1)*n+j);
                    if(j-1>=0&&grid[i][j-1]=='1') UF.Union(i*n+j,i*n+j-1);
                    if(j+1<n&&grid[i][j+1]=='1') UF.Union(i*n+j,i*n+j+1);
                }
            }
        }

        return UF.circleNum();
    }
};
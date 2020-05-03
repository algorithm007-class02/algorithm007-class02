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

        bool isConnecte(int x,int y){
            return find(x)==find(y);
        }
    private:
        int count;
        int *parent;
    };
    bool onEdge(int x,int y,int m,int n){
        return x==0||x==m-1||y==0||y==n-1;
    }
    void solve(vector<vector<char>>& board) {
        int m = board.size();
        if(m==0) return ;
        int n = board[0].size();
        if(n==0) return ;

        MyUF UF(m*n+1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(onEdge(i,j,m,n)&&board[i][j]=='O'){
                    UF.Union(i*n+j,m*n);
                }else if(board[i][j]=='O'){
                    if(board[i-1][j]=='O') UF.Union(i*n+j,(i-1)*n+j);
                    if(board[i+1][j]=='O') UF.Union(i*n+j,(i+1)*n+j);
                    if(board[i][j-1]=='O') UF.Union(i*n+j,i*n+j-1);
                    if(board[i][j+1]=='O') UF.Union(i*n+j,i*n+j+1);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!UF.isConnecte(i*n+j,m*n)) board[i][j] = 'X';
            }
        }
        return ;
    }
};
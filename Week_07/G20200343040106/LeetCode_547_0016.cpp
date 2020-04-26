// friend circle nums
// DFS,BFS,UnionFind    模板题

// DFS

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int ans = 0;
        vector<bool> isvisited = vector<bool>(M.size(),false);
        for(int i=0;i<M.size();++i){
            if(!isvisited[i]){
                dfs(M,isvisited,i);
                ans++;
            }
        }
        return ans;
    }

    void dfs(vector<vector<int>>& M,vector<bool>& isvisited,int cur){
        
        isvisited[cur] = true;
        for(int i=0;i<M.size();i++){
            if(M[cur][i]==1&&!isvisited[i]) dfs(M,isvisited,i);
        }

        return ;
    }
};

//BFS
class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int ans = 0;
        vector<bool> isvisited = vector<bool>(M.size(),false);
        for(int i=0;i<M.size();i++){
            if(!isvisited[i]){
                ans++;
                queue<int> q;
                q.push(i);
                while(!q.empty()){
                    int t = q.front();
                    q.pop();
                    for(int k=0;k<M.size();k++){
                        if(M[t][k]==1&&!isvisited[k]){
                            isvisited[k] = true;
                            q.push(k);
                        }
                    }
                }
            }
        }
        return ans;
    }
};

// 使用UnionFind解决
class Solution {
public:
    class MyUF{
    public:
        MyUF(int count){
            this->count = count;
            this->circlenum = count;
            parent = (int*)malloc(count*sizeof(int));
            for(int i=0;i<count;i++)
                parent[i] = i;
        }
        void Union(int kid1,int kid2){
            int p1 = find(kid1);
            int p2 = find(kid2);
            if(p1==p2) return ;
            parent[p1] = p2;
            circlenum--;
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
            for(int i=0;i<count;i++){
                cout<<parent[i]<<" ";
            }
            return circlenum;
        }
    private:
        int circlenum;
        int count;
        int *parent;
    };
public:
    int findCircleNum(vector<vector<int>>& M) {
        MyUF UF((int)M.size());
        for(int i=0;i<M.size();i++){
            for(int j=i;j<M.size();j++){
                if(M[i][j]==1) UF.Union(i,j);
            }
        }
        return UF.circleNum();
    }
};